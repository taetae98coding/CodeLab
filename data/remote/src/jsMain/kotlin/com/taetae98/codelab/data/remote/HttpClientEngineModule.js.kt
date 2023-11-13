package com.taetae98.codelab.data.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.js.Js
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal actual class HttpClientEngineModule actual constructor() {
    @Named(HttpClientModule.CLIENT_ENGINE)
    @Singleton
    actual fun providesHttpClientEngine(): HttpClientEngine {
        return Js.create()
    }
}
