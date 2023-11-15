package com.taetae98.codelab.feature.poke

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import com.taetae98.codelab.compose.icon.NavigateUpIcon
import com.taetae98.codelab.library.image.UriImage
import com.taetae98.codelab.library.paging.compose.safeGet

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun PokePageScreen(
    modifier: Modifier = Modifier,
    initialIndex: Int,
    onNavigateUp: () -> Unit,
    pokeItems: LazyPagingItems<PokeDetailUiState>,
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
    pokeItems: LazyPagingItems<PokeDetailUiState>,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = pokeItems.safeGet(pagerState.currentPage)?.name.orEmpty())
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
    pokeItems: LazyPagingItems<PokeDetailUiState>,
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
    ) {
        PokeDetail(
            modifier = Modifier.fillMaxSize(),
            uiState = pokeItems[it]
        )
    }
}

@Composable
private fun PokeDetail(
    modifier: Modifier = Modifier,
    uiState: PokeDetailUiState?
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        when (uiState) {
            is PokeDetailUiState.Detail -> {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(100.dp),
                ) {
                    items(
                        items = uiState.imageList,
                        key = { it },
                        contentType = { "image" }
                    ) {
                        UriImage(
                            modifier = Modifier.fillMaxWidth()
                                .aspectRatio(1F),
                            uri = it,
                            contentScale = ContentScale.FillWidth,
                        )
                    }
                }
            }

            else -> {
                CircularProgressIndicator()

                LaunchedEffect(uiState) {
                    if (uiState is PokeDetailUiState.Loading) {
                        uiState.onFetch()
                    }
                }
            }
        }
    }
}