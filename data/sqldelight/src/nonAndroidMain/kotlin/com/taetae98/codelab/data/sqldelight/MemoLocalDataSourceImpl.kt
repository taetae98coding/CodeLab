package com.taetae98.codelab.data.sqldelight

import app.cash.paging.PagingData
import app.cash.paging.createPager
import app.cash.paging.createPagingConfig
import app.cash.paging.map
import app.cash.sqldelight.paging3.QueryPagingSource
import com.taetae98.codelab.core.database.MemoEntity
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named

@Factory
internal class MemoLocalDataSourceImpl(
    private val memoDatabase: MemoDatabase,
    @Named(SqldelightLocalDataSourceModule.DATABASE_DISPATCHER)
    private val databaseDispatcher: CoroutineDispatcher,
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

    override fun page(): Flow<PagingData<MemoDto>> {
        val pager = createPager(
            config = createPagingConfig(pageSize = PAGE_SIZE),
            initialKey = null,
            pagingSourceFactory = {
                val queries = memoDatabase.memoEntityQueries

                QueryPagingSource(
                    countQuery = queries.count(),
                    transacter = queries,
                    context = databaseDispatcher,
                    queryProvider = queries::paging,
                )
            },
        )

        return pager.flow.map { it.map(MemoEntity::toDto) }
    }

    companion object {
        private const val PAGE_SIZE = 30
    }
}
