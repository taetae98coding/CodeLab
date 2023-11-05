package com.taetae98.codelab.library.lifecycle.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.StateFlow

@Composable
public actual fun <T> StateFlow<T>.collectAsStateLifecycle(): State<T> {
    return collectAsState()
}
