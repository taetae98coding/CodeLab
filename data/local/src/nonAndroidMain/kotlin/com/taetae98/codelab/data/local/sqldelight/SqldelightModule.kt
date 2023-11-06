package com.taetae98.codelab.data.local.sqldelight

import com.taetae98.codelab.core.database.MemoDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal expect class SqldelightModule {
    @Singleton
    fun providesMemoDatabase(): MemoDatabase
}