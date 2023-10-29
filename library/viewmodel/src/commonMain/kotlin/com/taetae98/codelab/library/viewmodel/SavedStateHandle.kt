package com.taetae98.codelab.library.viewmodel

import kotlinx.coroutines.flow.StateFlow

public expect class SavedStateHandle {
    public inline fun <reified T> getStateFlow(key: String, defaultValue: T): StateFlow<T>

    public suspend inline fun <reified T> set(key: String, value: T)
}