package com.taetae98.codelab.data.remote

import io.ktor.client.engine.HttpClientEngine
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal expect class HttpClientEngineModule() {
    @Named(HttpClientModule.CLIENT_ENGINE)
    @Singleton
    fun providesHttpClientEngine(): HttpClientEngine
}