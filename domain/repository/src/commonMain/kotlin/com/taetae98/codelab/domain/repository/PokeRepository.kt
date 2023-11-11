package com.taetae98.codelab.domain.repository

import app.cash.paging.PagingData
import com.taetae98.codelab.domain.entity.Poke
import kotlinx.coroutines.flow.Flow

public interface PokeRepository {
    public fun page(initialKey: Int?): Flow<PagingData<Poke>>
}
