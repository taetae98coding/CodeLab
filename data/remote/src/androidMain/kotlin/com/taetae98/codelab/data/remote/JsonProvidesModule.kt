package com.taetae98.codelab.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class JsonProvidesModule {
    @Provides
    @PokeJson
    @Singleton
    internal fun providesPokeJson(): Json {
        return JsonModule().providesPokeJson()
    }
}
