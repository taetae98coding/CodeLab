package com.taetae98.codelab.library.lifecycle.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.StateFlow

@Composable
public expect fun <T> StateFlow<T>.collectAsStateLifecycle(): State<T>