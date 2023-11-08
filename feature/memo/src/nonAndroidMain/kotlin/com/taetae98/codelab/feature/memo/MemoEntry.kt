package com.taetae98.codelab.feature.memo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.taetae98.codelab.library.inject.compose.koinInject
import com.taetae98.codelab.navigation.core.memo.MemoAddEntry
import com.taetae98.codelab.navigation.core.memo.MemoEntry
import com.taetae98.codelab.navigation.core.memo.MemoListEntry

@Composable
public fun MemoEntry(
    modifier: Modifier = Modifier,
    entry: MemoEntry,
) {
    Children(
        modifier = modifier,
        stack = entry.stack,
        animation = stackAnimation(),
    ) {
        when (val instance = it.instance) {
            is MemoListEntry -> {
                MemoListRoute(
                    onAdd = instance.onNavigateToMemoAdd,
                    viewModel = instance.koinInject(),
                )
            }

            is MemoAddEntry -> {
                MemoAddRoute(
                    onNavigateUp = instance.onNavigateUp,
                    viewModel = instance.koinInject(),
                )
            }
        }
    }
}
