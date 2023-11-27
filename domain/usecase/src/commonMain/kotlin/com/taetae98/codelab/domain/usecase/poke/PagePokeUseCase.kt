package com.taetae98.codelab.domain.usecase.poke

import app.cash.paging.PagingData
import com.taetae98.codelab.domain.entity.Poke
import com.taetae98.codelab.domain.repository.PokeRepository
import com.taetae98.codelab.domain.usecase.core.FlowUseCase
import com.taetae98.codelab.library.inject.KInject
import kotlin.jvm.JvmInline
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
public class PagePokeUseCase @KInject internal constructor(
    private val pokeRepository: PokeRepository
) : FlowUseCase<PagePokeUseCase.Params, PagingData<Poke>>() {
    override fun execute(params: Params): Flow<PagingData<Poke>> {
        return pokeRepository.page(params.initialKey)
    }

    @JvmInline
    public value class Params(
        public val initialKey: Int
    )
}
