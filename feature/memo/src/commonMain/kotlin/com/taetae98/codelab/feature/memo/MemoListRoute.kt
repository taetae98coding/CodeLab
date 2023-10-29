package com.taetae98.codelab.feature.memo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MemoListRoute(
    modifier: Modifier = Modifier,
    memoListViewModel: MemoListViewModel,
) {
    MemoListScreen(
        modifier = modifier,
    )
}