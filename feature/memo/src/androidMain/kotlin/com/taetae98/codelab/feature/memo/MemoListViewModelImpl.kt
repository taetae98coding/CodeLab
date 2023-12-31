package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.domain.usecase.memo.DeleteMemoUseCase
import com.taetae98.codelab.domain.usecase.memo.PageMemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MemoListViewModelImpl @Inject constructor(
    pageMemoUseCase: PageMemoUseCase,
    deleteMemoUseCase: DeleteMemoUseCase
) : MemoListViewModel(
    pageMemoUseCase = pageMemoUseCase,
    deleteMemoUseCase = deleteMemoUseCase
)
