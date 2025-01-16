package io.github.taetae98coding.codelab.data.poke

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.taetae98coding.codelab.core.poke.service.PokeService
import io.github.taetae98coding.codelab.data.poke.mapper.toDetail
import io.github.taetae98coding.codelab.data.poke.paging.PokePagingSource
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.domain.poke.entity.PokeDetail
import io.github.taetae98coding.codelab.domain.poke.repository.PokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Factory

@Factory
internal class PokeRepositoryImpl(
    private val remoteDataSource: PokeService,
) : PokeRepository {
    override fun pagingPoke(): Flow<PagingData<Poke>> {
        val pager = Pager(
            config = PagingConfig(
                pageSize = 30,
                jumpThreshold = 90,
            ),
            pagingSourceFactory = {
                PokePagingSource(
                    remoteDataSource = remoteDataSource,
                )
            },
        )

        return pager.flow
    }

    override fun getPokeDetail(id: Int): Flow<PokeDetail> {
        return flow { emit(remoteDataSource.getDetail(id).toDetail()) }
    }
}
