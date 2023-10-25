package com.taetae98.codelab.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.feature.webview.WebViewDecompose

@Composable
public fun AppRoute(
    modifier: Modifier = Modifier,
) {
    CodeLabTheme {
        WebViewDecompose()
    }
}
