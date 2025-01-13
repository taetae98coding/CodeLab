package io.github.taetae98coding.codelab.library.paging.compose.runtime

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.flow.Flow

@Composable
public expect fun <T : Any>  Flow<PagingData<T>>.collectAsLazyPagingItems(
    context: CoroutineContext = EmptyCoroutineContext
): LazyPagingItems<T>
