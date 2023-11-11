package com.taetae98.codelab.domain.usecase

import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.exception.TitleEmptyException
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.domain.usecase.memo.UpsertMemoUseCase
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import io.mockk.every
import io.mockk.mockk

class UpsertMemoUseCaseTest : BehaviorSpec({
    val repository = mockk<MemoRepository>(relaxed = true)
    val useCase = UpsertMemoUseCase(repository)

    Given("Memo title is empty.") {
        val memo = mockk<Memo> {
            every { title } returns ""
        }

        When("Call UpsertMemoUseCase") {
            val result = useCase(memo)

            Then("TitleEmptyException") {
                result.shouldBeFailure<TitleEmptyException>()
            }
        }
    }

    Given("Memo title has only blank char") {
        val memo = mockk<Memo> {
            every { title } returns "   \n   "
        }

        When("Call UpsertMemoUseCase") {
            val result = useCase(memo)

            Then("Success") {
                result shouldBeSuccess Unit
            }
        }
    }

    Given("Memo title is not empty") {
        val memo = mockk<Memo> {
            every { title } returns "title"
        }

        When("Call UpsertMemoUseCase") {
            val result = useCase(memo)

            Then("Success") {
                result shouldBeSuccess Unit
            }
        }
    }
})
