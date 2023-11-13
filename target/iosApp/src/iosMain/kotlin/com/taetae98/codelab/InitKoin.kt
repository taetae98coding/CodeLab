package com.taetae98.codelab

import com.taetae98.codelab.app.AppModule
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

public fun initKoin() {
    startKoin {
        modules(
            AppModule().module,
        )
    }
}
