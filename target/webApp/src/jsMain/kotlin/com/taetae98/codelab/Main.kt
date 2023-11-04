package com.taetae98.codelab

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import com.taetae98.codelab.app.AppEntry
import com.taetae98.codelab.app.AppModule
import com.taetae98.codelab.navigation.core.app.AppEntry
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import org.w3c.dom.Document

@OptIn(ExperimentalComposeUiApi::class)
internal fun main() {
    val lifecycle = LifecycleRegistry()
    val entry = AppEntry(DefaultComponentContext(lifecycle))

    lifecycle.attachToDocument()

    startKoin {
        modules(AppModule().module)
    }

    onWasmReady {
        CanvasBasedWindow {
            AppEntry(entry = entry)
        }
    }
}

private fun LifecycleRegistry.attachToDocument() {
    fun onVisibilityChanged() {
        if (document.visibilityState == "visible") {
            resume()
        } else {
            stop()
        }
    }

    onVisibilityChanged()

    document.addEventListener(type = "visibilitychange", callback = { onVisibilityChanged() })
}

private val Document.visibilityState: String
    get() = asDynamic().visibilityState.unsafeCast<String>()
