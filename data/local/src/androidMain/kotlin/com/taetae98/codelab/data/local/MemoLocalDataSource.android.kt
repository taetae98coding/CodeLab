package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.dto.MemoDto
import javax.inject.Inject

public actual class MemoLocalDataSource @Inject internal constructor(
    private val memoDatabase: MemoDatabase,
) {
    public actual suspend fun upsert(memo: MemoDto) {
        memoDatabase.memo().upsert(memo.toEntity())
    }
}
