package com.taetae98.codelab

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.taetae98.codelab.app.AppRoute

internal fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CodeLab"
        ) {
            AppRoute()
        }
    }
}