package com.taetae98.codelab.data.room

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class MemoLocalDataSourceImpl @Inject internal constructor(
    private val memoDatabase: MemoDatabase,
) : MemoLocalDataSource {
    override suspend fun upsert(memo: MemoDto) {
        memoDatabase.memo().upsert(memo.toEntity())
    }

    override suspend fun delete(id: Long) {
        memoDatabase.memo().delete(id)
    }

    override fun page(): Flow<PagingData<MemoDto>> {
        val pager = Pager(
            config = PagingConfig(
                pageSize = 30,
            ),
            initialKey = null,
            pagingSourceFactory = {
                memoDatabase.memo().page()
            },
        )

        return pager.flow.map { it.map(MemoEntity::toDto) }
    }
}
