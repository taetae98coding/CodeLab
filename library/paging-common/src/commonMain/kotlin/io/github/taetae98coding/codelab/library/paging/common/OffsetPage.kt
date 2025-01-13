package io.github.taetae98coding.codelab.library.paging.common

public data class OffsetPage<T : Any>(
    val count: Int,
    val data: List<T>,
)
