package com.taetae98.codelab.feature.datastore

import androidx.lifecycle.SavedStateHandle
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class DataStoreViewModelImpl @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : DatastoreViewModel(
    kSavedStateHandle = KSavedStateHandle(savedStateHandle)
)
