package com.taetae98.codelab.feature.memo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.library.lifecycle.compose.collectAsStateLifecycle

@Composable
internal fun MemoAddRoute(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    viewModel: MemoAddViewModel,
) {
    val titleUiState = viewModel.titleUiState.collectAsStateLifecycle()
    val messageUiState = viewModel.messageUiState.collectAsStateLifecycle()

    MemoAddScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
        uiState = viewModel.uiState,
        titleUiState = titleUiState,
        messageUiState = messageUiState,
    )
}
