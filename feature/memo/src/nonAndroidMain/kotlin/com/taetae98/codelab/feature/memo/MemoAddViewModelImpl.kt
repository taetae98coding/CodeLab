package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.domain.usecase.memo.MemoUpsertUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import org.koin.core.annotation.Factory

@Factory
internal class MemoAddViewModelImpl(
    kSavedStateHandle: KSavedStateHandle,
    memoUpsertUseCase: MemoUpsertUseCase,
) : MemoAddViewModel(
    kSavedStateHandle = kSavedStateHandle,
    memoUpsertUseCase = memoUpsertUseCase,
)
