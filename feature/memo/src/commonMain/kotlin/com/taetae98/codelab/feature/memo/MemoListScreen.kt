package com.taetae98.codelab.feature.memo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.itemContentType
import app.cash.paging.compose.itemKey
import com.taetae98.codelab.compose.icon.AddIcon
import com.taetae98.codelab.compose.icon.NavigateUpIcon

@Composable
internal fun MemoListScreen(modifier: Modifier = Modifier, onNavigateUp: () -> Unit, onAdd: () -> Unit, memoItems: LazyPagingItems<MemoUiState>, onDelete: (Long) -> Unit) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            AddButton(onAdd = onAdd)
        },
        topBar = {
            TopBar(onNavigateUp = onNavigateUp)
        },
    ) {
        Content(
            modifier = Modifier.fillMaxSize()
                .padding(it),
            memoItems = memoItems,
            onDelete = onDelete,
        )
    }
}

@Composable
private fun AddButton(modifier: Modifier = Modifier, onAdd: () -> Unit) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onAdd,
    ) {
        AddIcon()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        },
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Content(modifier: Modifier = Modifier, memoItems: LazyPagingItems<MemoUiState>, onDelete: (Long) -> Unit) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(
            count = memoItems.itemCount,
            key = memoItems.itemKey { it.id },
            contentType = memoItems.itemContentType { "Memo" },
        ) {
            Memo(
                modifier = Modifier.animateItemPlacement(),
                uiState = memoItems[it],
                onDelete = onDelete,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Memo(modifier: Modifier, uiState: MemoUiState?, onDelete: (Long) -> Unit) {
    val state = rememberDismissState(
        confirmValueChange = {
            if (uiState != null) {
                if (it != DismissValue.Default) {
                    onDelete(uiState.id)
                }

                true
            } else {
                false
            }
        },
    )

    SwipeToDismiss(
        modifier = modifier,
        state = state,
        background = {
        },
        dismissContent = {
            Card(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = uiState?.title.orEmpty(),
                )
            }
        },
    )
}
