package com.taetae98.codelab.data.remote

import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
public class PokeRemoteDataSource @KInject internal constructor() {
    public suspend fun page(limit: Int, offset: Int): List<PokeDto> {
        return emptyList()
    }
}
