package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.compose.textfield.TextFieldUiState
import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.usecase.memo.MemoUpsertUseCase
import com.taetae98.codelab.library.lifecycle.SavedStateHandle
import com.taetae98.codelab.library.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
internal actual class MemoAddViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val memoUpsertUseCase: MemoUpsertUseCase,
) : ViewModel() {
    actual val uiState = MemoAddUiState(
        onUpsert = ::upsert,
    )

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

    private val _messageUiState = MutableStateFlow(MemoMessageUiState(message = null, onMessageShow = ::updateMessage))
    actual val messageUiState = _messageUiState.asStateFlow()

    private fun setTitle(title: String) {
        savedStateHandle[TITLE] = title
    }

    private fun upsert() {
        viewModelScope.launch {
            val memo = Memo(
                id = 0L,
                title = title.value,
            )

            memoUpsertUseCase(memo)
                .onSuccess { setTitle("") }
                .onSuccess { updateMessage(MemoMessage.Upsert) }
        }
    }

    private fun updateMessage(message: MemoMessage? = null) {
        viewModelScope.launch {
            _messageUiState.emit(_messageUiState.value.copy(message = message))
        }
    }

    companion object {
        private const val TITLE = "title"
    }
}
