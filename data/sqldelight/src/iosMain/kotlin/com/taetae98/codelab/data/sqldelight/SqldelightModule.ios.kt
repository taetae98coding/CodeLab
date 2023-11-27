package com.taetae98.codelab.data.sqldelight

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import co.touchlab.sqliter.DatabaseConfiguration
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton

@Module
internal actual class SqldelightModule {
    @Named(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)
    @Singleton
    actual fun providesDatabaseDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Singleton
    actual fun providesMemoDatabase(): MemoDatabase {
        val driver = NativeSqliteDriver(
            schema = MemoDatabase.Schema,
            name = "memo.db",
            onConfiguration = { config ->
                config.copy(
                    extendedConfig = DatabaseConfiguration.Extended(foreignKeyConstraints = true)
                )
            }
        )

        return MemoDatabase(driver)
    }
}
