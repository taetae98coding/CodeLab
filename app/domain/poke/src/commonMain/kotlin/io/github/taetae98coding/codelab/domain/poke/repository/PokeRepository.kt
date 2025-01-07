package io.github.taetae98coding.codelab.domain.poke.repository

import androidx.paging.PagingData
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import kotlinx.coroutines.flow.Flow

public interface PokeRepository {
    public fun pagingPoke(): Flow<PagingData<Poke>>
}
