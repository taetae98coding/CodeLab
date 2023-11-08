package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.domain.usecase.memo.PageMemoUseCase
import org.koin.core.annotation.Factory

@Factory
internal class MemoListViewModelImpl(
    pageMemoUseCase: PageMemoUseCase,
) : MemoListViewModel(
    pageMemoUseCase,
)