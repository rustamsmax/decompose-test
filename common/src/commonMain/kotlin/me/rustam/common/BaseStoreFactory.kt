package me.rustam.common

import com.arkivanov.mvikotlin.core.store.Store

interface BaseStoreFactory<T: Store<*, *, *>> {
    fun create(): T
}