package com.taetae98.codelab.data.ktor

import io.ktor.client.engine.HttpClientEngine
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal expect class HttpClientEngineModule() {
    @Singleton
    fun providesHttpClientEngine(): HttpClientEngine
}
