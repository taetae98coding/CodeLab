package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.dto.MemoDto

public interface MemoLocalDataSource {
    public suspend fun upsert(memo: MemoDto)
}
