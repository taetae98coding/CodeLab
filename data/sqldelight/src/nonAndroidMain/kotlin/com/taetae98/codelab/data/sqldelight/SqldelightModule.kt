package com.taetae98.codelab.data.sqldelight

import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal expect class SqldelightModule {
    @Singleton
    fun providesMemoDatabase(): MemoDatabase
}