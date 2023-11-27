package com.taetae98.codelab.feature.datastore

import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import org.koin.core.annotation.Factory

@Factory
internal open class DatastoreViewModel(
    private val kSavedStateHandle: KSavedStateHandle
) : KViewModel() {
    private val value = kSavedStateHandle.getStateFlow(VALUE, "")

    val uiState = value.mapLatest {
        DatastoreUiState(
            value = it,
            setValue = ::setValue
        )
    }.stateIn(
        scope = kViewModelScope,
        started = SharingStarted.Lazily,
        initialValue = DatastoreUiState(
            value = value.value,
            setValue = ::setValue
        )
    )

    private fun setValue(value: String) {
        kSavedStateHandle[VALUE] = value
    }

    companion object {
        private const val VALUE = "value"
    }
}
