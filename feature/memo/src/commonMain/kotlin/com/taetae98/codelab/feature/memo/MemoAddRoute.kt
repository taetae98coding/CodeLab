package com.taetae98.codelab.feature.memo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MemoAddRoute(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    viewModel: MemoAddViewModel,
) {
    MemoAddScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
    )
}
