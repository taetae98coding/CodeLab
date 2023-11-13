package com.taetae98.codelab.data.repository.poke

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
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
        val limit = params.key ?: 0
        val offset = params.loadSize
        val data = pokeRemoteDataSource.page(limit, offset)

        return PagingSourceLoadResultPage<Int, PokeDto>(
            data = data,
            prevKey = null,
            nextKey = null,
        ) as PagingSourceLoadResult<Int, PokeDto>
    }
}
