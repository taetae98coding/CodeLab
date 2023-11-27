package com.taetae98.codelab.data.repository.poke

import app.cash.paging.PagingData
import app.cash.paging.createPager
import app.cash.paging.createPagingConfig
import app.cash.paging.map
import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.data.remote.PokeRemoteDataSource
import com.taetae98.codelab.domain.entity.Poke
import com.taetae98.codelab.domain.entity.PokeDetail
import com.taetae98.codelab.domain.repository.PokeRepository
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Factory

@Factory
internal class PokeRepositoryImpl @KInject constructor(
    private val pokeRemoteDataSource: PokeRemoteDataSource
) : PokeRepository {
    override fun page(initialKey: Int?): Flow<PagingData<Poke>> {
        val pager = createPager(
            config = createPagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
                jumpThreshold = PAGE_SIZE * 3
            ),
            pagingSourceFactory = {
                PokeRemotePagingSource(pokeRemoteDataSource)
            }
        )

        return pager.flow.map { it.map(PokeDto::toDomain) }
    }

    override suspend fun detail(id: Int): PokeDetail {
        return pokeRemoteDataSource.detail(id).toDomain()
    }

    companion object {
        private const val PAGE_SIZE = 30
    }
}
