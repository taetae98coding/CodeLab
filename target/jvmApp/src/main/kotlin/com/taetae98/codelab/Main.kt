package com.taetae98.codelab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.taetae98.codelab.app.AppRoute

internal fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CodeLab",
        ) {
            AppRoute(modifier = Modifier.fillMaxSize())
        }
    }
}
