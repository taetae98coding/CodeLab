package com.taetae98.codelab.feature.memo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.taetae98.codelab.domain.usecase.memo.MemoUpsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal actual class MemoAddViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val memoUpsertUseCase: MemoUpsertUseCase,
) : ViewModel()
