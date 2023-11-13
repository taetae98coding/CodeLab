package com.taetae98.codelab.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal class HttpClientModule {
    @Singleton
    @Named(POKE_CLIENT)
    fun providesPokeHttpClient(
        @Named(CLIENT_ENGINE)
        engine: HttpClientEngine,
        @Named(JsonModule.POKE_JSON)
        json: Json,
    ): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    companion object {
        const val CLIENT_ENGINE = "clientEngine"
        const val POKE_CLIENT = "pokeClient"
    }
}