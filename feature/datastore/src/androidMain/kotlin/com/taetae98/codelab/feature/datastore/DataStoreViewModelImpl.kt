package com.taetae98.codelab.feature.datastore

import androidx.lifecycle.SavedStateHandle
import com.taetae98.codelab.domain.usecase.datastore.GetDatastoreUseCase
import com.taetae98.codelab.domain.usecase.datastore.UpdateDatastoreUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class DataStoreViewModelImpl @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getDatastoreUseCase: GetDatastoreUseCase,
    updateDatastoreUseCase: UpdateDatastoreUseCase
) : DatastoreViewModel(
    kSavedStateHandle = KSavedStateHandle(savedStateHandle),
    getDatastoreUseCase = getDatastoreUseCase,
    updateDatastoreUseCase = updateDatastoreUseCase
)
