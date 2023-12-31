package com.taetae98.codelab.library.lifecycle

import kotlinx.coroutines.flow.StateFlow

public expect class KSavedStateHandle {
    public fun getStateFlow(key: String, initialValue: String): StateFlow<String>

    public fun getStateFlow(key: String, initialValue: Int): StateFlow<Int>

    public operator fun set(key: String, value: String)

    public operator fun set(key: String, value: Int)
}
