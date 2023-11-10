package com.taetae98.codelab

import com.taetae98.codelab.app.AppModule
import com.taetae98.codelab.data.sqldelight.SqldelightLocalDataSourceModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.context.startKoin
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import org.koin.ksp.generated.module

public fun initKoin() {
    startKoin {
        modules(
            AppModule().module,
            module {
                single(qualifier = StringQualifier(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)) { Dispatchers.IO }
            }
        )
    }
}
