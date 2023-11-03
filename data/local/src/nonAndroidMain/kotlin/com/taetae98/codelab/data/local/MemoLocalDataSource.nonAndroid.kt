package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.dto.MemoDto

public actual class MemoLocalDataSource {
    public actual suspend fun upsert(memo: MemoDto) {
    }
}
