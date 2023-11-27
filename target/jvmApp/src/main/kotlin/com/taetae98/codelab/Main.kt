package com.taetae98.codelab

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.taetae98.codelab.app.AppEntry
import com.taetae98.codelab.app.AppModule
import com.taetae98.codelab.navigation.core.app.AppEntry
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

internal fun main() {
    val entry = AppEntry(DefaultComponentContext(LifecycleRegistry()))

    startKoin {
        modules(AppModule().module)
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CodeLab"
        ) {
            AppEntry(entry = entry)
        }
    }
}
