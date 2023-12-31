package com.taetae98.codelab.feature.memo

import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import com.taetae98.codelab.domain.entity.MemoId
import com.taetae98.codelab.domain.usecase.memo.DeleteMemoUseCase
import com.taetae98.codelab.domain.usecase.memo.PageMemoUseCase
import com.taetae98.codelab.library.lifecycle.KViewModel
import com.taetae98.codelab.library.paging.mapPagingLatest
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
internal open class MemoListViewModel(
    pageMemoUseCase: PageMemoUseCase,
    private val deleteMemoUseCase: DeleteMemoUseCase
) : KViewModel() {
    private val paging = pageMemoUseCase(Unit).mapLatest { it.getOrDefault(PagingData.empty()) }
        .cachedIn(scope = kViewModelScope)

    val memoItems = paging.mapPagingLatest {
        MemoUiState(
            id = it.id,
            title = it.title
        )
    }.cachedIn(scope = kViewModelScope)

    fun onDelete(id: Long) {
        kViewModelScope.launch {
            deleteMemoUseCase(MemoId(id))
        }
    }
}
