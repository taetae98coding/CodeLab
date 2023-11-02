package com.taetae98.codelab.library.lifecycle.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

@Composable
public actual fun <T> StateFlow<T>.collectAsStateLifecycle(): State<T> {
    return collectAsStateWithLifecycle()
}