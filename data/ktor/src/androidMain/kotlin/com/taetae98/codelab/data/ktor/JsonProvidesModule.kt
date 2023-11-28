package com.taetae98.codelab.data.ktor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json

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
