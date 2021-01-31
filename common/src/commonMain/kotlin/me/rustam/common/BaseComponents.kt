package me.rustam.common

import com.arkivanov.decompose.RouterState
import com.arkivanov.decompose.value.Value

interface BaseRootComponent<Child: Any> {

    val routerState: Value<RouterState<*, Child>>
}

interface BaseComponent<Model: Any> {
    val model: Value<Model>
}

interface NavComponent<Child: Any>{

    fun onAppBackPressed()
}

interface BaseNavComponent<Model: Any> : BaseComponent<Model>, NavComponent<Model>