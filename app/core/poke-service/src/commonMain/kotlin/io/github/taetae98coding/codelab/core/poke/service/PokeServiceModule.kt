package io.github.taetae98coding.codelab.core.poke.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.DefaultJson
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan
public class PokeServiceModule {
    @Single
    @Named(POKE_SERVICE_JSON)
    internal fun providesPokeServiceJson(): Json {
        return Json(DefaultJson) {
            ignoreUnknownKeys = true
        }
    }

    @Single
    @Named(POKE_HTTP_CLIENT)
    internal fun providesPokeHttpClient(
        @Named(PokeHttpClientEngineModule.POKE_HTTP_CLIENT_ENGINE)
        engine: HttpClientEngine,
        @Named(POKE_SERVICE_JSON)
        json: Json,
    ): HttpClient {
        return HttpClient(engine) {
            defaultRequest {
                url("https://pokeapi.co/api/v2/")
            }

            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    public companion object {
        internal const val POKE_SERVICE_JSON = "POKE_SERVICE_JSON"
        internal const val POKE_HTTP_CLIENT = "POKE_HTTP_CLIENT"
    }
}
