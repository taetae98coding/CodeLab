package com.taetae98.codelab.data.sqldelight

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan
public actual class SqldelightModule {
//    @Singleton
//    internal actual fun providesMemoDatabase(): MemoDatabase {
//        val driver = JdbcSqliteDriver(
//            url = "jdbc:sqlite:memo.db",
//            properties = Properties().apply { put("foreign_keys", "true") },
//        ).also {
//            if (!File("memo.db").exists()) {
//                MemoDatabase.Schema.create(it)
//            }
//        }
//
//        return MemoDatabase(driver)
//    }
}