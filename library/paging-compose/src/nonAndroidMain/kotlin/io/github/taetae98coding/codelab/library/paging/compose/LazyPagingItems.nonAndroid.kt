package io.github.taetae98coding.codelab.library.paging.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.paging.ItemSnapshotList
import androidx.paging.PagingData
import androidx.paging.PagingDataEvent
import androidx.paging.PagingDataPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

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

    private fun updateItemSnapshotList() {
        itemSnapshotList = pagingDataPresenter.snapshot()
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
}
