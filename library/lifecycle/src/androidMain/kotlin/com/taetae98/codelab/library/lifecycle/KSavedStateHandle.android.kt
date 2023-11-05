package com.taetae98.codelab.library.lifecycle

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.StateFlow

public actual class KSavedStateHandle(
    private val savedStateHandle: SavedStateHandle,
) {
    public actual fun getStateFlow(key: String, initialValue: String): StateFlow<String> {
        return savedStateHandle.getStateFlow(key, initialValue)
    }

    public actual operator fun set(key: String, value: String) {
        savedStateHandle[key] = value
    }
}
