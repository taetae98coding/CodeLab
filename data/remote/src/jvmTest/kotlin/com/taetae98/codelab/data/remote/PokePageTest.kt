package com.taetae98.codelab.data.remote

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeExactly

class PokePageTest : BehaviorSpec({
    Given("given") {
        val service = PokeService()

        When("when") {
            val page = service.page(20, 0)

            Then("then") {
                page.count shouldBeExactly 20
            }
        }
    }
})
