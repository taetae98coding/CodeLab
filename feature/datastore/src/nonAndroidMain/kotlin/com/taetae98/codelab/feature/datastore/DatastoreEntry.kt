package com.taetae98.codelab.feature.datastore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.library.inject.compose.koinInject
import com.taetae98.codelab.navigation.core.datastore.DatastoreEntry

@Composable
public fun DatastoreEntry(modifier: Modifier = Modifier, entry: DatastoreEntry) {
    DatastoreRoute(
        modifier = modifier,
        viewModel = entry.koinInject(),
        onNavigateUp = entry.onNavigateUp
    )
}
