package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.compose.textfield.TextFieldUiState
import com.taetae98.codelab.domain.usecase.memo.MemoUpsertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.annotation.Factory

@Factory
internal actual class MemoAddViewModel(
    private val memoUpsertUseCase: MemoUpsertUseCase,
) {
    actual val uiState: MemoAddUiState = MemoAddUiState({})

    private val _titleUiState = MutableStateFlow(TextFieldUiState("", {}))
    actual val titleUiState = _titleUiState.asStateFlow()
}
