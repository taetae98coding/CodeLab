package com.taetae98.codelab.feature.memo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems

@Composable
internal fun MemoListRoute(modifier: Modifier = Modifier, onAdd: () -> Unit, viewModel: MemoListViewModel) {
    MemoListScreen(
        modifier = modifier,
        onAdd = onAdd,
        viewModel.memoItems.collectAsLazyPagingItems(),
    )
}
