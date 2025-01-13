package io.github.taetae98coding.codelab.core.poke.service

import io.github.taetae98coding.codelab.core.poke.service.ext.providesHttpClientEngine
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
public class PokeHttpClientEngineModule {
    @Single
    @Named(POKE_HTTP_CLIENT_ENGINE)
    internal fun providesPokeHttpClientEngine(): HttpClientEngine {
        return providesHttpClientEngine()
    }

    public companion object {
        internal const val POKE_HTTP_CLIENT_ENGINE = "POKE_HTTP_CLIENT_ENGINE"
    }
}
