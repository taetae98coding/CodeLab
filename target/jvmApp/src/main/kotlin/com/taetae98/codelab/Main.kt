package com.taetae98.codelab

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.taetae98.codelab.app.AppEntry
import com.taetae98.codelab.navigation.core.app.AppEntry

internal fun main() {
    val entry = AppEntry(DefaultComponentContext(LifecycleRegistry()))

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CodeLab",
        ) {
            AppEntry(entry = entry)
        }
    }
}
