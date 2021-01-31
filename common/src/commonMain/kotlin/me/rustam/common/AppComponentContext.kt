package me.rustam.common

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.Router
import com.arkivanov.decompose.statekeeper.Parcelable
import me.rustam.common.model.UserProfile
import kotlin.reflect.KClass

interface AppComponentContext: ComponentContext {
    val currentUser: UserProfile
}

fun ComponentContext.appComponentContext(user: UserProfile): AppComponentContext =
    object: AppComponentContext, ComponentContext by this {
        override val currentUser: UserProfile = user
    }


fun AppComponentContext.appComponentContext(context: ComponentContext): AppComponentContext =
    object : AppComponentContext, ComponentContext by context {
        override val currentUser = this@appComponentContext.currentUser
    }

fun AppComponentContext.child(key: String): AppComponentContext =
    appComponentContext(child(key))

fun <C : Parcelable, T : Any> AppComponentContext.appRouter(
    initialConfiguration: C,
    configurationClass: KClass<out C>,
    key: String = "DefaultRouter",
    handleBackButton: Boolean = false,
    componentFactory: (configuration: C, AppComponentContext) -> T
): Router<C, T> =
    router(
        initialConfiguration = { initialConfiguration },
        configurationClass = configurationClass,
        key = key,
        handleBackButton = handleBackButton
    ) { configuration, componentContext ->
        componentFactory(configuration, appComponentContext(componentContext))
    }
inline fun <reified C : Parcelable, T : Any> AppComponentContext.appRouter(
    initialConfiguration: C,
    key: String = "DefaultRouter",
    handleBackButton: Boolean = false,
    noinline componentFactory: (configuration: C, AppComponentContext) -> T
): Router<C, T> =
    appRouter(
        initialConfiguration = initialConfiguration,
        configurationClass = C::class,
        key = key,
        handleBackButton = handleBackButton,
        componentFactory = componentFactory
    )