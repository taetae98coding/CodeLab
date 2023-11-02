package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.compose.textfield.TextFieldUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal actual class MemoAddViewModel {
    actual val uiState: MemoAddUiState = MemoAddUiState({})

    private val _titleUiState = MutableStateFlow(TextFieldUiState("", {}))
    actual val titleUiState = _titleUiState.asStateFlow()
}
