package com.taetae98.codelab.feature.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun MainRoute(modifier: Modifier = Modifier, onWebView: () -> Unit, onMemo: () -> Unit, onPoke: () -> Unit, onDatastore: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar() }
    ) {
        MainItemColum(
            modifier = Modifier.padding(it)
                .fillMaxSize(),
            onWebView = onWebView,
            onMemo = onMemo,
            onPoke = onPoke,
            onDatastore = onDatastore
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "CodeLab")
        }
    )
}

@Composable
private fun MainItemColum(modifier: Modifier = Modifier, onWebView: () -> Unit, onMemo: () -> Unit, onPoke: () -> Unit, onDatastore: () -> Unit) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MainItem(
            title = "WebView CodeLab",
            platformList = persistentListOf(Platform.ANDROID, Platform.IOS, Platform.JVM),
            description = "Platfrom WebView CodeLab",
            onClick = onWebView
        )

        MainItem(
            title = "Memo CodeLab",
            platformList = persistentListOf(
                Platform.ANDROID,
                Platform.IOS,
                Platform.JVM
            ),
            description = """
                Database CodeLab
                - Android : Room
                - Non android : SQLDelight

                Simple memo app.
            """.trimIndent(),
            onClick = onMemo
        )

        MainItem(
            title = "Poke CodeLab",
            platformList = persistentListOf(
                Platform.ANDROID,
                Platform.IOS,
                Platform.JVM,
                Platform.JS
            ),
            description = """
                Network, Paging API CodeLab
                - Paging3
                - Ktor

                Poke list.
            """.trimIndent(),
            onClick = onPoke
        )

        MainItem(
            title = "Datastore CodeLab",
            platformList = persistentListOf(
                Platform.ANDROID
            ),
            description = """
                Preference CodeLab
                - Datastore
            """.trimIndent(),
            onClick = onDatastore
        )
    }
}
