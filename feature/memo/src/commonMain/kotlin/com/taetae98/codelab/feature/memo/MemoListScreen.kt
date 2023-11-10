package com.taetae98.codelab.feature.memo

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.LazyPagingItems
import com.taetae98.codelab.compose.icon.AddIcon

@Composable
internal fun MemoListScreen(modifier: Modifier = Modifier, onAdd: () -> Unit, memoItems: LazyPagingItems<String>) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            AddButton(onAdd = onAdd)
        },
    ) {
        LazyColumn {
            items(count = memoItems.itemCount) {
                Text(memoItems[it].orEmpty())
            }
        }
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
