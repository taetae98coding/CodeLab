package io.github.taetae98coding.codelab.library.paging.common

class FakeOffsetPagingSource(
    private val count: Int,
) : OffsetPagingSource<Unit>() {
    override suspend fun page(limit: Int, offset: Int): OffsetPage<Unit> {
        val size = minOf(limit, (count - offset).coerceAtLeast(0))

        return OffsetPage(
            count = count,
            data = List(size) {},
        )
    }
}
