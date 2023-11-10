package com.taetae98.codelab

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.taetae98.codelab.app.AppEntry
import com.taetae98.codelab.app.AppModule
import com.taetae98.codelab.data.sqldelight.SqldelightLocalDataSourceModule
import com.taetae98.codelab.navigation.core.app.AppEntry
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.startKoin
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import org.koin.ksp.generated.module

internal fun main() {
    val entry = AppEntry(DefaultComponentContext(LifecycleRegistry()))

    startKoin {
        modules(
            AppModule().module,
            module {
                single(
                    qualifier = StringQualifier(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER),
                ) {
                    Dispatchers.IO
                }
            },
        )
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CodeLab",
        ) {
            AppEntry(entry = entry)
        }
    }
}
