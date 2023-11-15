package com.taetae98.codelab.feature.poke

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.LazyPagingItems
import com.taetae98.codelab.compose.icon.NavigateUpIcon

@Composable
internal fun PokePageScreen(
    modifier: Modifier = Modifier,
    initialIndex: Int,
    onNavigateUp: () -> Unit,
    pokeItems: LazyPagingItems<PokeUiState>,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavigateUp = onNavigateUp) }
    ) {
        Content(
            modifier = Modifier.padding(it),
            initialIndex = initialIndex,
            pokeItems = pokeItems,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Content(
    modifier: Modifier = Modifier,
    initialIndex: Int,
    pokeItems: LazyPagingItems<PokeUiState>,
) {
    val state = rememberPagerState(
        initialPage = initialIndex,
        pageCount = { pokeItems.itemCount }
    )

    HorizontalPager(
        modifier = modifier,
        state = state,
    ) {
        Text(it.toString())
    }
}