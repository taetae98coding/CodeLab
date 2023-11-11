package com.taetae98.codelab.feature.memo

import androidx.lifecycle.SavedStateHandle
import com.taetae98.codelab.domain.usecase.memo.UpsertMemoUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MemoAddViewModelImpl @Inject constructor(
    savedStateHandle: SavedStateHandle,
    upsertMemoUseCase: UpsertMemoUseCase,
) : MemoAddViewModel(
    kSavedStateHandle = KSavedStateHandle(savedStateHandle),
    upsertMemoUseCase = upsertMemoUseCase,
)
