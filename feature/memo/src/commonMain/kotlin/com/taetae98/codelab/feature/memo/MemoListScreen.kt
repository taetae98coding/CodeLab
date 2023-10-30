package com.taetae98.codelab.feature.memo

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.compose.icon.AddIcon

@Composable
internal fun MemoListScreen(
    modifier: Modifier = Modifier,
    onAdd: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            AddButton(onAdd = onAdd)
        },
    ) {
    }
}

@Composable
private fun AddButton(
    modifier: Modifier = Modifier,
    onAdd: () -> Unit,
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onAdd,
    ) {
        AddIcon()
    }
}
