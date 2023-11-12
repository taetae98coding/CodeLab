package com.taetae98.codelab.data.remote

import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
internal class PokeService @KInject constructor() {
    suspend fun page(limit: Int, offset: Int): PokePageEntity {
        return PokePageEntity(0)
    }
}