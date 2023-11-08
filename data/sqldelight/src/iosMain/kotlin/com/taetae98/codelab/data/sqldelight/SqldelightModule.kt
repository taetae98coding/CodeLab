package com.taetae98.codelab.data.sqldelight

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import co.touchlab.sqliter.DatabaseConfiguration
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal actual class SqldelightModule {
    @Singleton
    actual fun providesMemoDatabase(): MemoDatabase {
        val driver = NativeSqliteDriver(
            schema = MemoDatabase.Schema,
            name = "memo.db",
            onConfiguration = { config ->
                config.copy(
                    extendedConfig = DatabaseConfiguration.Extended(foreignKeyConstraints = true),
                )
            },
        )

        return MemoDatabase(driver)
    }
}