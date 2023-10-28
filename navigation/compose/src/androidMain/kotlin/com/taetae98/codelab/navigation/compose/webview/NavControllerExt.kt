package com.taetae98.codelab.navigation.compose.webview

import androidx.navigation.NavController
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

public fun NavController.navigateToWebView() {
    navigate(WebViewEntry.ROUTE)
}
