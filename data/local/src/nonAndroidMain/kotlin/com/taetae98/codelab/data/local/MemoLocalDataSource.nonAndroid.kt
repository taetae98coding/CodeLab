package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.dto.MemoDto
import org.koin.core.annotation.Factory

@Factory
public actual class MemoLocalDataSource {
    public actual suspend fun upsert(memo: MemoDto) {
    }
}
