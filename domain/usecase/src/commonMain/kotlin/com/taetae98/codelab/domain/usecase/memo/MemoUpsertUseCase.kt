package com.taetae98.codelab.domain.usecase.memo

import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.exception.TitleEmptyException
import com.taetae98.codelab.domain.usecase.core.UseCase
import com.taetae98.codelab.library.inject.KInject

public class MemoUpsertUseCase @KInject internal constructor() : UseCase<Memo, Unit>() {
    override suspend fun execute(params: Memo) {
        if (params.title.isEmpty()) throw TitleEmptyException()

        println("Hi")
    }
}
