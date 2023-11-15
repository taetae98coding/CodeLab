package com.taetae98.codelab.feature.poke

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun PokePageScreen(
    modifier: Modifier = Modifier,
    initialIndex: Int,
    onNavigateUp: () -> Unit,
    pokeItems: LazyPagingItems<PokeUiState>,
) {
    val pagerState = rememberPagerState(
        initialPage = initialIndex,
        pageCount = { pokeItems.itemCount }
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                onNavigateUp = onNavigateUp,
                pagerState = pagerState,
                pokeItems = pokeItems,
            )
        }
    ) {
        Content(
            modifier = Modifier.padding(it),
            pagerState = pagerState,
            pokeItems = pokeItems,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    pagerState: PagerState,
    pokeItems: LazyPagingItems<PokeUiState>,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            val item = if (pokeItems.itemCount > pagerState.currentPage) {
                pokeItems[pagerState.currentPage]
            } else {
                null
            }

            Text(text = item?.name.orEmpty())
        },
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
    pagerState: PagerState,
    pokeItems: LazyPagingItems<PokeUiState>,
) {


    HorizontalPager(
        modifier = modifier,
        state = pagerState,
    ) {
        Text(it.toString())
    }
}