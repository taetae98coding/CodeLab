package com.taetae98.codelab.data.ktor

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal actual class HttpClientEngineModule actual constructor() {
    @Singleton
    actual fun providesHttpClientEngine(): HttpClientEngine {
        return OkHttp.create()
    }
}