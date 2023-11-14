package com.taetae98.codelab.data.repository.poke

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.data.remote.PokeRemoteDataSource

internal class PokeRemotePagingSource(
    private val pokeRemoteDataSource: PokeRemoteDataSource,
) : PagingSource<Int, PokeDto>() {
    override fun getRefreshKey(state: PagingState<Int, PokeDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, PokeDto> {
        return try {
            val pageLimit = params.loadSize
            val pageOffset = params.key ?: 0
            val apiLimit = pageLimit + pageOffset.coerceAtMost(0)
            val apiOffset = pageOffset.coerceAtLeast(0)
            val page = pokeRemoteDataSource.page(apiLimit, apiOffset)

            PagingSourceLoadResultPage(
                data = page.data,
                prevKey = (pageOffset - pageLimit).takeIf { pageOffset > 0 },
                nextKey = (pageOffset + pageLimit).takeIf { it <= page.count },
                itemsBefore = apiOffset,
                itemsAfter = (page.count - page.data.size - apiOffset),
            )
        } catch (e: Exception) {
            PagingSourceLoadResultError<Int, PokeDto>(e)
        } as PagingSourceLoadResult<Int, PokeDto>
    }

    override val jumpingSupported: Boolean = true
}
