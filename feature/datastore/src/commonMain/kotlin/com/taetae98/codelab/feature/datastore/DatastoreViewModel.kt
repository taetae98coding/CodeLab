package com.taetae98.codelab.feature.datastore

import com.taetae98.codelab.domain.usecase.datastore.GetDatastoreUseCase
import com.taetae98.codelab.domain.usecase.datastore.UpdateDatastoreUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
internal open class DatastoreViewModel(
    private val kSavedStateHandle: KSavedStateHandle,
    private val getDatastoreUseCase: GetDatastoreUseCase,
    private val updateDatastoreUseCase: UpdateDatastoreUseCase
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

    init {
        kViewModelScope.launch {
            getDatastoreUseCase(Unit).firstOrNull()?.getOrNull()?.let(::setValue)
            launch { collectValueAndUpdateDatastore() }
        }
    }

    private fun setValue(value: String) {
        kSavedStateHandle[VALUE] = value
    }

    private suspend fun collectValueAndUpdateDatastore() {
        value.drop(1)
            .debounce(300L)
            .collectLatest { updateDatastoreUseCase(it) }
    }

    companion object {
        private const val VALUE = "value"
    }
}
