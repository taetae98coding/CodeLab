package com.taetae98.codelab.domain.usecase.memo

import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.domain.usecase.core.UseCase
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
public class DeleteMemoUseCase @KInject internal constructor(
    private val memoRepository: MemoRepository,
) : UseCase<MemoId, Unit>() {
    override suspend fun execute(params: MemoId) {
        memoRepository.delete(params.id)
    }
}
