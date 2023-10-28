package com.taetae98.codelab.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.taetae98.codelab.feature.main.MainEntry
import com.taetae98.codelab.feature.webview.WebViewEntry
import com.taetae98.codelab.navigation.core.app.AppEntry
import com.taetae98.codelab.navigation.core.main.MainEntry
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

@Composable
public fun AppEntry(
    modifier: Modifier = Modifier,
    entry: AppEntry,
) {
    Children(
        modifier = modifier,
        stack = entry.stack,
        animation = stackAnimation(),
    ) {
        when (val instance = it.instance) {
            is MainEntry -> MainEntry(entry = instance)
            is WebViewEntry -> WebViewEntry(entry = instance)
        }
    }
}
