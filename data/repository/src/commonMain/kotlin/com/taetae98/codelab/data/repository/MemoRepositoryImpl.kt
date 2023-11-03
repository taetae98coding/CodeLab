package com.taetae98.codelab.data.repository

import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.library.inject.KInject

internal class MemoRepositoryImpl @KInject constructor() : MemoRepository {
    override suspend fun upsert(memo: Memo) {
        println("memo : $memo")
    }
}
