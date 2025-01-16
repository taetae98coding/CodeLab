package io.github.taetae98coding.codelab.library.paging.compose.ext

import androidx.paging.compose.itemKey
import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems

public actual fun <T : Any> LazyPagingItems<T>.itemKey(
    key: ((@JvmSuppressWildcards T) -> Any)?,
): (Int) -> Any {
    return itemKey(key)
}
