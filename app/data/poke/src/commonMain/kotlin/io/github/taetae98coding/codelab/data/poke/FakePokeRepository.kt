package io.github.taetae98coding.codelab.data.poke

import androidx.paging.PagingData
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.domain.poke.repository.PokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.annotation.Factory

@Factory
internal class FakePokeRepository : PokeRepository {
    override fun pagingPoke(): Flow<PagingData<Poke>> {
        val pokeList = List(100) {
            Poke(
                id = it + 1,
                name = "Poke ${it + 1}",
                thumbnail = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it + 1}.png",
            )
        }

        return flowOf(PagingData.from(pokeList))
    }
}
