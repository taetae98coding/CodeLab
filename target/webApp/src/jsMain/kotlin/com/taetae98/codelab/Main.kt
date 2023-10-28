package com.taetae98.codelab

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.taetae98.codelab.app.AppRoute
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
internal fun main() {
    onWasmReady {
        CanvasBasedWindow {
            AppRoute()
        }
    }
}
