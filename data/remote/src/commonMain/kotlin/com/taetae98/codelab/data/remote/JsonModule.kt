package com.taetae98.codelab.data.remote

import kotlinx.serialization.json.Json
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal class JsonModule {

    @Singleton
    @Named(POKE_JSON)
    fun providesPokeJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    companion object {
        const val POKE_JSON = "pokeJson"
    }
}