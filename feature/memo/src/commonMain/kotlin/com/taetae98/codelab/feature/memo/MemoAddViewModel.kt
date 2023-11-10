package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.compose.textfield.TextFieldUiState
import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.usecase.memo.MemoUpsertUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
internal open class MemoAddViewModel(
    private val kSavedStateHandle: KSavedStateHandle,
    private val memoUpsertUseCase: MemoUpsertUseCase,
) : KViewModel() {

    val uiState = MemoAddUiState(
        onUpsert = ::upsert,
    )

    private val title = kSavedStateHandle.getStateFlow(TITLE, "")
    val titleUiState = title.map {
        TextFieldUiState(
            value = it,
            onValueChange = ::setTitle,
        )
    }.stateIn(
        scope = kViewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = TextFieldUiState(
            value = title.value,
            onValueChange = ::setTitle,
        ),
    )

    private val _messageUiState =
        MutableStateFlow(MemoMessageUiState(message = null, onMessageShow = ::updateMessage))
    val messageUiState = _messageUiState.asStateFlow()

    private fun setTitle(title: String) {
        kSavedStateHandle[TITLE] = title
    }

    private fun upsert() {
        kViewModelScope.launch {
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
        kViewModelScope.launch {
            _messageUiState.emit(_messageUiState.value.copy(message = message))
        }
    }

    companion object {
        private const val TITLE = "title"
    }
}
