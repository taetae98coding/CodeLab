package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.dto.MemoDto

public expect class MemoLocalDataSource {
    public suspend fun upsert(memo: MemoDto)
}
