package com.taetae98.codelab.data.repository.poke

import app.cash.paging.PagingData
import com.taetae98.codelab.domain.entity.Poke
import com.taetae98.codelab.domain.repository.PokeRepository
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.annotation.Factory

@Factory
internal class PokeRepositoryImpl @KInject constructor(

) : PokeRepository {
    override fun page(initialKey: Int?): Flow<PagingData<Poke>> {
        return flowOf(PagingData.empty())
    }
}