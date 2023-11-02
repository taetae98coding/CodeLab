package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.compose.textfield.TextFieldUiState
import kotlinx.coroutines.flow.StateFlow

internal expect class MemoAddViewModel {
    val uiState: MemoAddUiState
    val titleUiState: StateFlow<TextFieldUiState>
}
