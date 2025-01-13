package io.github.taetae98coding.codelab.data.poke.paging

import io.github.taetae98coding.codelab.core.poke.service.PokeService
import io.github.taetae98coding.codelab.core.poke.service.entity.PokePageEntity
import io.github.taetae98coding.codelab.data.poke.mapper.toPoke
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.library.paging.common.OffsetPage
import io.github.taetae98coding.codelab.library.paging.common.OffsetPagingSource

internal class PokePagingSource(
    private val remoteDataSource: PokeService,
) : OffsetPagingSource<Poke>() {
    override suspend fun page(limit: Int, offset: Int): OffsetPage<Poke> {
        val entity = remoteDataSource.page(limit, offset)

        return OffsetPage(
            count = entity.count,
            data = entity.results.map(PokePageEntity::toPoke),
        )
    }
}
