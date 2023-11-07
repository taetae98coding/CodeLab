package com.taetae98.codelab.data.room

import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import javax.inject.Inject

public class MemoLocalDataSourceImpl @Inject internal constructor(
    private val memoDatabase: MemoDatabase,
) : MemoLocalDataSource {
    override suspend fun upsert(memo: MemoDto) {
        memoDatabase.memo().upsert(memo.toEntity())
    }
}
