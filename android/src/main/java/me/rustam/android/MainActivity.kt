package me.rustam.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.rootComponent
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import me.rustam.common.answer.FeedListRootComponent
import me.rustam.common.answer.toAppBackPressHandler
import me.rustam.common.appComponentContext
import me.rustam.common.model.UserProfile
import me.rustam.compose.FeedRootContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedRootContent(rootComponent(::root))
        }
    }

    private fun root(componentContext: ComponentContext): FeedListRootComponent =
        FeedListRootComponent(
            componentContext = componentContext.appComponentContext(
                user = UserProfile(
                    name = "A Tester"
                )
            ),
            dependencies = object : FeedListRootComponent.Dependencies {
                override val storeFactory: StoreFactory =
                    LoggingStoreFactory(TimeTravelStoreFactory(DefaultStoreFactory))

            },
            backPressHandler = toAppBackPressHandler { onBackPressed() }
        )
}
