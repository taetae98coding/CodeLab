package com.taetae98.codelab.data.ktor

import com.taetae98.codelab.data.ktor.poke.PokeHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import javax.inject.Singleton
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
internal class HttpClientProvidesModule {
    @Provides
    @PokeHttpClient
    @Singleton
    internal fun providesPokeHttpClient(
        engine: HttpClientEngine,
        @PokeJson
        json: Json
    ): HttpClient {
        return HttpClientModule().providesPokeHttpClient(
            engine = engine,
            json = json
        )
    }
}
