package com.taetae98.codelab.feature.memo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.router.stack.ChildStack
import com.taetae98.codelab.compose.icon.AddIcon
import com.taetae98.codelab.compose.icon.NavigateUpIcon
import com.taetae98.codelab.navigation.core.Entry
import com.taetae98.codelab.navigation.core.memo.MemoEntry
import com.taetae98.codelab.navigation.core.memo.MemoListEntry

@Composable
public fun MemoEntry(
    modifier: Modifier = Modifier,
    entry: MemoEntry,
) {
    val state = entry.stack.subscribeAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(onNavigateUp = entry.onNavigateUp)
        },
        floatingActionButton = {
            FloatingButton(
                state = state,
                onMemoAdd = entry::navigateToMemoAdd,
            )
        }
    ) {
        Content(
            modifier = Modifier.padding(it),
            state = state,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        }
    )
}

@Composable
private fun FloatingButton(
    modifier: Modifier = Modifier,
    state: State<ChildStack<*, Entry>>,
    onMemoAdd: () -> Unit,
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onMemoAdd,
    ) {
        AddIcon()
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    state: State<ChildStack<*, Entry>>,
) {
    Children(
        modifier = modifier,
        stack = state.value,
        animation = stackAnimation()
    ) {
        when (it.instance) {
            is MemoListEntry -> MemoListRoute(memoListViewModel = MemoListViewModel())
        }
    }
}