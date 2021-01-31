package me.rustam.common.answer

import com.arkivanov.decompose.Router
import com.arkivanov.decompose.pop

interface AppBackPressHandler {
    fun onAppBackPress()
}

fun toAppBackPressHandler(handle: () -> Unit) : AppBackPressHandler =
    object : AppBackPressHandler{
        override fun onAppBackPress() {
            handle()
        }
    }

fun Router<*, *>.toAppBackPressHandler(): AppBackPressHandler =
    object : AppBackPressHandler{
        override fun onAppBackPress() {
            this@toAppBackPressHandler.pop()
        }
    }