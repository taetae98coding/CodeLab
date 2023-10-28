package com.taetae98.codelab.feature.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun MainRoute(
    modifier: Modifier = Modifier,
    onWebView: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar() },
    ) {
        MainItemColum(
            modifier = Modifier.padding(it)
                .fillMaxSize(),
            onWebView = onWebView,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "CodeLab")
        },
    )
}

@Composable
private fun MainItemColum(
    modifier: Modifier = Modifier,
    onWebView: () -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MainItem(
            title = "WebView CodeLab",
            platformList = persistentListOf(Platform.ANDROID, Platform.IOS, Platform.JVM),
            onClick = onWebView,
        )
    }
}
