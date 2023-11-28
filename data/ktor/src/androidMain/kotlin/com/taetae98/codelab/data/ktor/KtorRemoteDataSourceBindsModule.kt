package com.taetae98.codelab.data.ktor

import com.taetae98.codelab.data.ktor.poke.PokeRemoteDataSourceImpl
import com.taetae98.codelab.data.remote.PokeRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface KtorRemoteDataSourceBindsModule {
    @Binds
    fun bindsPokeRemoteDataSource(dataSource: PokeRemoteDataSourceImpl): PokeRemoteDataSource
}
