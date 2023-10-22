package com.taetae98.codelab

import androidx.compose.material.Text
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

internal fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CodeLab"
        ) {
            Text(text = "Hello World")
        }
    }
}