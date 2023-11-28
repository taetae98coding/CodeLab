package com.taetae98.codelab.data.ktor

import kotlinx.serialization.json.Json
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal class JsonModule {

    @Named(POKE_JSON)
    @Singleton
    fun providesPokeJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    companion object {
        const val POKE_JSON = "pokeJson"
    }
}
