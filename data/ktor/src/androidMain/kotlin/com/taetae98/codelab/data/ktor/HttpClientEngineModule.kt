package com.taetae98.codelab.data.ktor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class HttpClientEngineModule {
    @Provides
    @Singleton
    internal fun providesHttpClientEngine(): HttpClientEngine {
        return OkHttp.create()
    }
}
