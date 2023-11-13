package com.taetae98.codelab.data.sqldelight

import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal expect class SqldelightModule {
    @Named(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)
    @Singleton
    fun providesDatabaseDispatcher(): CoroutineDispatcher

    @Singleton
    fun providesMemoDatabase(): MemoDatabase
}
