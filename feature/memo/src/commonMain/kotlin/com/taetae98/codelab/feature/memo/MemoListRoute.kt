package com.taetae98.codelab.feature.memo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems

@Composable
internal fun MemoListRoute(modifier: Modifier = Modifier, onNavigateUp: () -> Unit, onAdd: () -> Unit, viewModel: MemoListViewModel) {
    MemoListScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
        onAdd = onAdd,
        memoItems = viewModel.memoItems.collectAsLazyPagingItems(),
        onDelete = viewModel::onDelete,
    )
}
