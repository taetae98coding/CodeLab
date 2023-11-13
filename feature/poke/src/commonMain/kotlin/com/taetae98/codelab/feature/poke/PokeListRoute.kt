package com.taetae98.codelab.feature.poke

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems

@Composable
internal fun PokeListRoute(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    viewModel: PokeListViewModel,
) {
    PokeListScreen(
        modifier = modifier,
        pokeItems = viewModel.pokeUiState.collectAsLazyPagingItems(),
    )
}
