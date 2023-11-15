package com.taetae98.codelab.domain.usecase.poke

import com.taetae98.codelab.domain.entity.PokeDetail
import com.taetae98.codelab.domain.entity.PokeId
import com.taetae98.codelab.domain.repository.PokeRepository
import com.taetae98.codelab.domain.usecase.core.UseCase
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
public class GetPokeDetailUseCase @KInject internal constructor(
    private val pokeRepository: PokeRepository,
) : UseCase<PokeId, PokeDetail>() {
    override suspend fun execute(params: PokeId): PokeDetail {
        return pokeRepository.detail(params.id)
    }
}