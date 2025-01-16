package io.github.taetae98coding.codelab.library.paging.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.paging.CombinedLoadStates
import androidx.paging.ItemSnapshotList
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.PagingDataEvent
import androidx.paging.PagingDataPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
public actual class LazyPagingItems<T : Any> internal constructor(
    private val flow: Flow<PagingData<T>>,
) {
    private val pagingDataPresenter = object : PagingDataPresenter<T>(
        mainContext = Dispatchers.Main,
        cachedPagingData =
            if (flow is SharedFlow<PagingData<T>>) {
                flow.replayCache.firstOrNull()
            } else {
                null
            },
    ) {
        override suspend fun presentPagingDataEvent(
            event: PagingDataEvent<T>,
        ) {
            updateItemSnapshotList()
        }
    }

    public actual val itemCount: Int get() = itemSnapshotList.size

    public var itemSnapshotList: ItemSnapshotList<T> by mutableStateOf(pagingDataPresenter.snapshot())
        private set

    public actual var loadState: CombinedLoadStates by mutableStateOf(
        pagingDataPresenter.loadStateFlow.value ?: CombinedLoadStates(
            refresh = InitialLoadStates.refresh,
            prepend = InitialLoadStates.prepend,
            append = InitialLoadStates.append,
            source = InitialLoadStates,
        ),
    )
        private set

    private fun updateItemSnapshotList() {
        itemSnapshotList = pagingDataPresenter.snapshot()
    }

    internal suspend fun collectLoadState() {
        pagingDataPresenter.loadStateFlow.filterNotNull().collect {
            loadState = it
        }
    }

    internal suspend fun collectPagingData() {
        flow.collectLatest {
            pagingDataPresenter.collectFrom(it)
        }
    }

    public actual operator fun get(index: Int): T? {
        pagingDataPresenter[index]
        return itemSnapshotList[index]
    }

    public actual fun peek(index: Int): T? {
        return itemSnapshotList[index]
    }
}

private val IncompleteLoadState = LoadState.NotLoading(false)
private val InitialLoadStates = LoadStates(
    LoadState.Loading,
    IncompleteLoadState,
    IncompleteLoadState
)
