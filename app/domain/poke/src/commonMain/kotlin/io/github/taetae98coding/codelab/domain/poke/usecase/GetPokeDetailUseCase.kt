package io.github.taetae98coding.codelab.domain.poke.usecase

import io.github.taetae98coding.codelab.domain.poke.entity.PokeDetail
import io.github.taetae98coding.codelab.domain.poke.repository.PokeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import org.koin.core.annotation.Factory

@OptIn(ExperimentalCoroutinesApi::class)
@Factory
public class GetPokeDetailUseCase internal constructor(
    private val pokeRepository: PokeRepository,
) {
    public operator fun invoke(id: Int): Flow<Result<PokeDetail>> {
        return flow { emitAll(pokeRepository.getPokeDetail(id)) }
            .mapLatest { Result.success(it) }
            .catch { emit(Result.failure(it)) }
    }
}
