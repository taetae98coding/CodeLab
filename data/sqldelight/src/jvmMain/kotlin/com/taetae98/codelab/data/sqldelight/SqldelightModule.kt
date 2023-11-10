package com.taetae98.codelab.data.sqldelight

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import java.io.File
import java.util.Properties

@Module
internal actual class SqldelightModule {
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
