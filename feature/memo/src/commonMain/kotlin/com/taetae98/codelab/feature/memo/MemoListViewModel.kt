package com.taetae98.codelab.feature.memo

import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import app.cash.paging.map
import com.taetae98.codelab.domain.usecase.memo.DeleteMemoUseCase
import com.taetae98.codelab.domain.usecase.memo.MemoId
import com.taetae98.codelab.domain.usecase.memo.PageMemoUseCase
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
internal open class MemoListViewModel(
    pageMemoUseCase: PageMemoUseCase,
    private val deleteMemoUseCase: DeleteMemoUseCase,
) : KViewModel() {
    private val paging = pageMemoUseCase(Unit).mapLatest { it.getOrDefault(PagingData.empty()) }
        .cachedIn(scope = kViewModelScope)

    val memoItems = paging.mapLatest { pagingData ->
        pagingData.map {
            MemoUiState(
                id = it.id,
                title = it.title,
            )
        }
    }

    fun onDelete(id: Long) {
        kViewModelScope.launch {
            deleteMemoUseCase(MemoId(id))
        }
    }
}
