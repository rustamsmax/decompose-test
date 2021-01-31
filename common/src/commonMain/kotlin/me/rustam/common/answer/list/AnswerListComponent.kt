package me.rustam.common.answer.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.badoo.reaktive.observable.Observable
import me.rustam.common.AppComponentContext
import me.rustam.common.BaseNavComponent
import me.rustam.common.answer.AppBackPressHandler
import me.rustam.common.answer.list.FeedListComponent.Dependencies
import me.rustam.common.answer.list.impl.FeedListComponentImpl
import me.rustam.common.model.Feed
import me.rustam.common.model.UserProfile

interface FeedListComponent: BaseNavComponent<FeedListComponent.Model> {

    fun onInquirySelected(id: Long)


    data class Model(
        val userProfile: UserProfile,
        val feeds: List<Feed>
    )

    sealed class Input{
        object Refresh: Input()
    }

    sealed class Output {
        data class InquirySelected(val id: Long) : Output()
    }


    interface Dependencies {
        val storeFactory: StoreFactory
        val answerListInput: Observable<Input>
        val answerListOutput: Consumer<Output>
    }
}

fun FeedListComponent(
    componentContext: AppComponentContext,
    dependencies: Dependencies,
    backPressHandler: AppBackPressHandler
): FeedListComponent = FeedListComponentImpl(componentContext, dependencies, backPressHandler)