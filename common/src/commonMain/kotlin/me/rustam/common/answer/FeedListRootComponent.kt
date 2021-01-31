package me.rustam.common.answer

import com.arkivanov.decompose.*
import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelize
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.badoo.reaktive.observable.Observable
import com.badoo.reaktive.observable.mapNotNull
import com.badoo.reaktive.subject.publish.PublishSubject
import me.rustam.common.AppComponentContext
import me.rustam.common.Consume
import me.rustam.common.answer.FeedListRootComponent.Child
import me.rustam.common.answer.FeedListRootComponent.Dependencies
import me.rustam.common.answer.list.FeedListComponent
import me.rustam.common.answer.view.FeedViewComponent
import me.rustam.common.answer.view.InquiryViewComponent
import me.rustam.common.appRouter
import me.rustam.common.model.Feed
import uz.abroad.common.main.root.answer.viewOutputToListInput


internal val sampleData = listOf(
    Feed(id = 1L, title = "Title 1", content = "Content 1"),
    Feed(id = 2L, title = "Title 2", content = "Content 2"),
    Feed(id = 3L, title = "Title 3", content = "Content 3"),
    Feed(id = 4L, title = "Title 4", content = "Content 4"),
    Feed(id = 5L, title = "Title 5", content = "Content 5"),
    Feed(id = 6L, title = "Title 6", content = "Content 6"),
)


interface FeedListRootComponent {

    val routerState: Value<RouterState<*, Child>>

    sealed class Child {
        data class InquiryList(val component: FeedListComponent) : Child()
        data class InquiryView(val component: FeedViewComponent) : Child()
    }

    interface Dependencies {
        val storeFactory: StoreFactory
    }
}

fun FeedListRootComponent(
    componentContext: AppComponentContext,
    dependencies: Dependencies,
    backPressHandler: AppBackPressHandler
): FeedListRootComponent =
    FeedListRootComponentImpl(componentContext, dependencies, backPressHandler)

internal class FeedListRootComponentImpl(
    componentContext: AppComponentContext,
    dependencies: Dependencies,
    backPressHandler: AppBackPressHandler
) : FeedListRootComponent,
    AppComponentContext by componentContext,
    Dependencies by dependencies,
    AppBackPressHandler by backPressHandler {

    private val viewOutput = PublishSubject<FeedViewComponent.Output>()

    private val router = appRouter<Configuration, Child>(
        key = "InquiryListRoot",
        initialConfiguration = Configuration.InquiryList,
        handleBackButton = true,
        componentFactory = ::createChild
    )

    override val routerState: Value<RouterState<*, Child>> = router.state

    private fun createChild(
        configuration: Configuration,
        componentContext: AppComponentContext
    ): Child {
        return when (configuration) {
            Configuration.InquiryList -> Child.InquiryList(
                inquiryList(componentContext)
            )
            is Configuration.InquiryView -> Child.InquiryView(
                inquiryView(componentContext, configuration.id)
            )
        }
    }

    private fun inquiryList(componentContext: AppComponentContext): FeedListComponent =
        FeedListComponent(
            componentContext = componentContext,
            dependencies = object : FeedListComponent.Dependencies, Dependencies by this {
                override val answerListInput: Observable<FeedListComponent.Input> =
                    viewOutput.mapNotNull(viewOutputToListInput)
                override val answerListOutput = Consume<FeedListComponent.Output> { output ->
                    when (output) {
                        is FeedListComponent.Output.InquirySelected -> router.push(
                            Configuration.InquiryView(output.id)
                        )
                    }
                }
            },
            backPressHandler = this
        )


    private fun inquiryView(componentContext: AppComponentContext, id: Long): FeedViewComponent =
        InquiryViewComponent(
            componentContext = componentContext,
            dependencies = object : FeedViewComponent.Dependencies, Dependencies by this {
                override val answerViewOutput: Consumer<FeedViewComponent.Output> = viewOutput
                override val feedId: Long = id
            },
            backPressHandler = toAppBackPressHandler { router.pop() }
        )

    private sealed class Configuration : Parcelable {
        @Parcelize
        object InquiryList : Configuration()

        @Parcelize
        data class InquiryView(val id: Long) : Configuration()
    }
}
