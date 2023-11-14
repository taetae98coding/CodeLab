package com.taetae98.codelab.data.sqldelight

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton
import java.io.File
import java.util.Properties

@Module
internal actual class SqldelightModule {
    @Named(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)
    @Singleton
    actual fun providesDatabaseDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Singleton
    actual fun providesMemoDatabase(): MemoDatabase {
        val driver = JdbcSqliteDriver(
            url = "jdbc:sqlite:memo.db",
            properties = Properties().apply { put("foreign_keys", "true") },
        ).also {
            if (!File("memo.db").exists()) {
                MemoDatabase.Schema.create(it)
            }
        }

        return MemoDatabase(driver)
    }
}
