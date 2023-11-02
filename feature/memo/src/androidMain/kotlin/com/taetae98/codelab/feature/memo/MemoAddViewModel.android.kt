package com.taetae98.codelab.feature.memo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taetae98.codelab.compose.textfield.TextFieldUiState
import com.taetae98.codelab.domain.usecase.memo.MemoUpsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal actual class MemoAddViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val memoUpsertUseCase: MemoUpsertUseCase,
) : ViewModel() {
    private val title = savedStateHandle.getStateFlow(TITLE, "")

    actual val titleUiState = title.map {
        TextFieldUiState(
            value = it,
            onValueChange = ::setTitle,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = TextFieldUiState(
            value = title.value,
            onValueChange = ::setTitle,
        ),
    )

    private fun setTitle(title: String) {
        savedStateHandle[TITLE] = title
    }

    companion object {
        private const val TITLE = "title"
    }
}
