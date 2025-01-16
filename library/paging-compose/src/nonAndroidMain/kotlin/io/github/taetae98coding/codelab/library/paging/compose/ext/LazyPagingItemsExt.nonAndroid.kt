package io.github.taetae98coding.codelab.library.paging.compose.ext

import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems
import kotlin.jvm.JvmSuppressWildcards

public actual fun <T : Any> LazyPagingItems<T>.itemKey(
    key: ((@JvmSuppressWildcards T) -> Any)?,
): (Int) -> Any {
    return { index ->
        if (key == null) {
            index
        } else {
            peek(index)?.let { key(it) } ?: index
        }
    }
}

public actual fun <T : Any> LazyPagingItems<T>.itemContentType(contentType: ((@JvmSuppressWildcards T) -> Any?)?): (Int) -> Any? {
    return { index ->
        if (contentType == null) {
            null
        } else {
            peek(index)?.let { contentType(it) } ?: index
        }
    }
}
