package com.taetae98.codelab.library.webview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import com.sun.javafx.application.PlatformImpl
import javafx.embed.swing.JFXPanel
import javafx.scene.Scene
import javafx.scene.web.WebView

@Composable
public actual fun WebView(
    modifier: Modifier,
    uiState: WebViewUiState,
) {
    SwingPanel(
        modifier = modifier,
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
                webView.engine.load("https://www.naver.com")
            }
        }
    )
}
