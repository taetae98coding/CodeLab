package com.taetae98.codelab.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.taetae98.codelab.feature.datastore.DatastoreEntry
import com.taetae98.codelab.feature.main.MainEntry
import com.taetae98.codelab.feature.memo.MemoEntry
import com.taetae98.codelab.feature.poke.PokeEntry
import com.taetae98.codelab.feature.webview.WebViewEntry
import com.taetae98.codelab.navigation.core.app.AppEntry
import com.taetae98.codelab.navigation.core.datastore.DatastoreEntry
import com.taetae98.codelab.navigation.core.main.MainEntry
import com.taetae98.codelab.navigation.core.memo.MemoEntry
import com.taetae98.codelab.navigation.core.poke.PokeEntry
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

@Composable
public fun AppEntry(modifier: Modifier = Modifier, entry: AppEntry) {
    CodeLabTheme {
        Children(
            modifier = modifier,
            stack = entry.stack,
            animation = stackAnimation()
        ) {
            when (val instance = it.instance) {
                is MainEntry -> MainEntry(entry = instance)
                is WebViewEntry -> WebViewEntry(entry = instance)
                is MemoEntry -> MemoEntry(entry = instance)
                is PokeEntry -> PokeEntry(entry = instance)
                is DatastoreEntry -> DatastoreEntry(entry = instance)
            }
        }
    }
}
