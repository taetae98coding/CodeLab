package com.taetae98.codelab.data.sqldelight

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [SqldelightModule::class]
)
@ComponentScan
public class SqldelightLocalDataSourceModule {
    public companion object {
        internal const val DATABASE_DISPATCHER: String = "databaseDispatcher"
    }
}
