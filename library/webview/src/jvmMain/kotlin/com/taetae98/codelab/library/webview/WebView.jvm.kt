package com.taetae98.codelab.library.webview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.round
import com.sun.javafx.application.PlatformImpl
import javafx.embed.swing.JFXPanel
import javafx.scene.Scene
import javafx.scene.web.WebView
import kotlin.math.roundToInt

@Composable
public actual fun WebView(
    modifier: Modifier,
    uiState: WebViewUiState,
) {
    Box(modifier = modifier) {
        SwingPanel(
            factory = {
                JFXPanel().also {
                    PlatformImpl.runAndWait {
                        val route = WebView()
                        val scene = Scene(route)

                        it.scene = scene
                    }
                }
            },
            update = {
                PlatformImpl.runAndWait {
                    val webView = it.scene.root as WebView
                    when (uiState) {
                        is WebViewUiState.Url -> webView.engine.load(uiState.url)
                        is WebViewUiState.Html -> webView.engine.loadContent(uiState.html, "text/html")
                    }
                }
            },
        )
    }
}
