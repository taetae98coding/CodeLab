package com.taetae98.codelab.data.sqldelight

import com.taetae98.codelab.core.database.MemoDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
@ComponentScan
public actual class SqldelightModule {
    @Singleton
    internal actual fun providesMemoDatabase(): MemoDatabase {
        TODO("Not yet implemented")
    }
}