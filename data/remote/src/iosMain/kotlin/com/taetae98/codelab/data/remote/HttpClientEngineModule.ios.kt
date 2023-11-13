package com.taetae98.codelab.data.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal actual class HttpClientEngineModule actual constructor() {
    @Singleton
    @Named(HttpClientModule.CLIENT_ENGINE)
    actual fun providesHttpClientEngine(): HttpClientEngine {
        return Darwin.create()
    }
}
