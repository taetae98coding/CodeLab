package com.taetae98.codelab.data.sqldelight

import app.cash.paging.PagingSource
import app.cash.sqldelight.paging3.QueryPagingSource
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named

@Factory
internal class MemoLocalDataSourceImpl(
    private val memoDatabase: MemoDatabase,
    @Named(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)
    private val databaseDispatcher: CoroutineDispatcher
) : MemoLocalDataSource {
    override suspend fun upsert(memo: MemoDto) {
        withContext(databaseDispatcher) {
            if (memo.id == 0L) {
                memoDatabase.memoEntityQueries.insert(null, memo.title)
            } else {
                memoDatabase.memoEntityQueries.upsert(memo.toEntity())
            }
        }
    }

    override suspend fun delete(id: Long) {
        withContext(databaseDispatcher) {
            memoDatabase.memoEntityQueries.delete(id)
        }
    }

    override fun page(): PagingSource<Int, MemoDto> {
        val queries = memoDatabase.memoEntityQueries

        return QueryPagingSource(
            countQuery = queries.count(),
            transacter = queries,
            context = databaseDispatcher,
            queryProvider = { limit, offset ->
                queries.paging(limit, offset, ::MemoDto)
            }
        )
    }
}
