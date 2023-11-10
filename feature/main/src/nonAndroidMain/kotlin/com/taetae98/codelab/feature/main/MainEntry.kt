package com.taetae98.codelab.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.navigation.core.main.MainEntry

@Composable
public fun MainEntry(modifier: Modifier = Modifier, entry: MainEntry) {
    MainRoute(
        modifier = modifier,
        onWebView = entry.onWebView,
        onMemo = entry.onMemo,
    )
}
