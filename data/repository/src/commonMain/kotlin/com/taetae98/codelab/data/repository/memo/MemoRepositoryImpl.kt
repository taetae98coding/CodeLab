package com.taetae98.codelab.data.repository.memo

import app.cash.paging.PagingData
import app.cash.paging.createPager
import app.cash.paging.createPagingConfig
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.library.inject.KInject
import com.taetae98.codelab.library.paging.mapPaging
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
internal class MemoRepositoryImpl @KInject constructor(
    private val memoLocalDataSource: MemoLocalDataSource
) : MemoRepository {
    override suspend fun upsert(memo: Memo) {
        memoLocalDataSource.upsert(memo.toDto())
    }

    override suspend fun delete(id: Long) {
        memoLocalDataSource.delete(id)
    }

    override fun page(): Flow<PagingData<Memo>> {
        val pager = createPager(
            config = createPagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                memoLocalDataSource.page()
            }
        )

        return pager.flow.mapPaging(MemoDto::toDomain)
    }

    companion object {
        private const val PAGE_SIZE = 30
    }
}
