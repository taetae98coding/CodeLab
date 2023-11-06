package com.taetae98.codelab.data.local.sqldelight

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.taetae98.codelab.core.database.MemoDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal actual class SqldelightModule {
    @Singleton
    actual fun providesMemoDatabase(): MemoDatabase {
        return MemoDatabase(JdbcSqliteDriver("jdbc:sqlite:memo.db"))
    }
}