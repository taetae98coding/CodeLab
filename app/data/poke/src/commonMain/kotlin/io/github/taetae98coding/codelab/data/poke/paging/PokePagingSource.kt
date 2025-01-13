package io.github.taetae98coding.codelab.data.poke.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.taetae98coding.codelab.core.poke.service.PokeService
import io.github.taetae98coding.codelab.core.poke.service.entity.PokePageEntity
import io.github.taetae98coding.codelab.data.poke.mapper.toPoke
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import kotlin.math.min

internal class PokePagingSource(
    private val remoteDataSource: PokeService,
) : PagingSource<Int, Poke>() {
    override val jumpingSupported = true

    override fun getRefreshKey(state: PagingState<Int, Poke>): Int? {
        return state.anchorPosition?.let { maxOf(0, it - (state.config.initialLoadSize / 2)) }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Poke> {
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
            val page = remoteDataSource.page(limit, offset)

            if (invalid) {
                LoadResult.Invalid()
            } else {
                LoadResult.Page(
                    data = page.results.map(PokePageEntity::toPoke),
                    prevKey = offset.takeIf { it > 0 && page.results.isNotEmpty() },
                    nextKey = (offset + page.results.size).takeIf { page.results.isNotEmpty() && page.results.size >= limit && it < page.count },
                    itemsBefore = offset,
                    itemsAfter = maxOf(0, page.count - (offset + page.results.size)),
                )
            }
        } catch (throwable: Throwable) {
            LoadResult.Error(throwable)
        }
    }
}
