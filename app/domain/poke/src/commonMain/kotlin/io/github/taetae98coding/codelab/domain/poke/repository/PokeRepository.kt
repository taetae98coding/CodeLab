package io.github.taetae98coding.codelab.domain.poke.repository

import androidx.paging.PagingData
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.domain.poke.entity.PokeDetail
import kotlinx.coroutines.flow.Flow

public interface PokeRepository {
    public fun pagingPoke(): Flow<PagingData<Poke>>
    public fun getPokeDetail(id: Int): Flow<PokeDetail>
}
