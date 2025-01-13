package io.github.taetae98coding.codelab.library.paging.common

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlin.math.min

public abstract class OffsetPagingSource<T : Any> : PagingSource<Int, T>() {
    override val jumpingSupported: Boolean = true

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { maxOf(0, it - (state.config.initialLoadSize / 2)) }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val key = params.key ?: 0
            val limit = when (params) {
                is LoadParams.Prepend<*> -> min(key, params.loadSize)
                else -> params.loadSize
            }
            val offset = when (params) {
                is LoadParams.Prepend<*> -> maxOf(0, key - params.loadSize)
                else -> key
            }
            val page = page(limit, offset)

            if (invalid) {
                LoadResult.Invalid()
            } else {
                LoadResult.Page(
                    data = page.data,
                    prevKey = offset.takeIf { it > 0 && page.data.isNotEmpty() },
                    nextKey = (offset + page.data.size).takeIf { page.data.isNotEmpty() && page.data.size >= limit && it < page.count },
                    itemsBefore = offset,
                    itemsAfter = maxOf(0, page.count - (offset + page.data.size)),
                )
            }
        } catch (throwable: Throwable) {
            LoadResult.Error(throwable)
        }
    }

    public abstract suspend fun page(limit: Int, offset: Int): OffsetPage<T>
}
