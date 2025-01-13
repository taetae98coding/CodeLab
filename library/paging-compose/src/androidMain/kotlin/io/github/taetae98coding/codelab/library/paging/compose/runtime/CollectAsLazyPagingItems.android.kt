package io.github.taetae98coding.codelab.library.paging.compose.runtime

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow

@Composable
public actual fun <T : Any> Flow<PagingData<T>>.collectAsLazyPagingItems(
    context: CoroutineContext
): LazyPagingItems<T> {
    return collectAsLazyPagingItems(context)
}
