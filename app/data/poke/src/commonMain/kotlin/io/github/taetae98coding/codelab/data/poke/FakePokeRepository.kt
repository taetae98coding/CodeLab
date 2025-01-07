package io.github.taetae98coding.codelab.data.poke

import androidx.paging.PagingData
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.domain.poke.repository.PokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class FakePokeRepository : PokeRepository {
    override fun pagingPoke(): Flow<PagingData<Poke>> {
        val pokeList = List(100) {
            Poke(
                id = it,
                name = "Poke $it",
            )
        }

        return flowOf(PagingData.from(pokeList))
    }
}
