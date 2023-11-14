package com.taetae98.codelab.data.remote

import com.taetae98.codelab.data.dto.PokePageDto
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
public class PokeRemoteDataSource @KInject internal constructor(
    private val pokeService: PokeService,
) {
    public suspend fun page(limit: Int, offset: Int): PokePageDto {
        return pokeService.page(limit, offset).toDto()
    }
}
