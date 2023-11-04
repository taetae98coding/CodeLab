package com.taetae98.codelab.domain.usecase.memo

import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.exception.TitleEmptyException
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.domain.usecase.core.UseCase
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
public class MemoUpsertUseCase @KInject internal constructor(
    private val memoRepository: MemoRepository,
) : UseCase<Memo, Unit>() {
    override suspend fun execute(params: Memo) {
        if (params.title.isEmpty()) throw TitleEmptyException()

        memoRepository.upsert(params)
    }
}
