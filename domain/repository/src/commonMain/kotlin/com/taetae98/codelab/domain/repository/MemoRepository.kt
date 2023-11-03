package com.taetae98.codelab.domain.repository

import com.taetae98.codelab.domain.entity.Memo

public interface MemoRepository {
    public suspend fun upsert(memo: Memo)
}
