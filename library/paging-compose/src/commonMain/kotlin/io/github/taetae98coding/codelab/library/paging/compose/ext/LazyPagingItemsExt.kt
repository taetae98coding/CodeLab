package io.github.taetae98coding.codelab.library.paging.compose.ext

import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems
import kotlin.jvm.JvmSuppressWildcards

public expect fun <T : Any> LazyPagingItems<T>.itemKey(
    key: ((item: @JvmSuppressWildcards T) -> Any)? = null,
): (index: Int) -> Any

public expect fun <T : Any> LazyPagingItems<T>.itemContentType(
    contentType: ((item: @JvmSuppressWildcards T) -> Any?)? = null
): (index: Int) -> Any?
