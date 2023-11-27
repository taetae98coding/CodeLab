package com.taetae98.codelab.feature.datastore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.library.lifecycle.compose.collectAsStateLifecycle

@Composable
internal fun DatastoreRoute(
    modifier: Modifier = Modifier,
    viewModel: DatastoreViewModel,
    onNavigateUp: () -> Unit,
) {
    val uiState = viewModel.uiState.collectAsStateLifecycle()

    DatastoreScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
        uiState = uiState,
    )
}
