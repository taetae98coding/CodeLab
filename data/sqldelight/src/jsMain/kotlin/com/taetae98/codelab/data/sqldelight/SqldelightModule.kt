package com.taetae98.codelab.data.sqldelight

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal actual class SqldelightModule {
    @Named(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)
    @Singleton
    actual fun providesDatabaseDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    @Singleton
    actual fun providesMemoDatabase(): MemoDatabase {
        TODO("JS 공부 후 적용")
    }
}
