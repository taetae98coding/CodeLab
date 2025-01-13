package io.github.taetae98coding.codelab.data.poke.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.taetae98coding.codelab.core.poke.service.PokeService
import io.github.taetae98coding.codelab.domain.poke.entity.Poke

internal class PokePagingSource(
    private val remoteDataSource: PokeService,
) : PagingSource<Int, Poke>() {
    override fun getRefreshKey(state: PagingState<Int, Poke>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Poke> {
        TODO("Not yet implemented")
    }
}
