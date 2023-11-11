package com.taetae98.codelab.data.room

import androidx.paging.PagingSource
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
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

    override fun page(): PagingSource<Int, MemoDto> {
        return memoDatabase.memo().page()
    }
}
