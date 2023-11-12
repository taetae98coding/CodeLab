package com.taetae98.codelab.data.remote

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeExactly
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokePageTest : BehaviorSpec({
    Given("given") {
        val engin = MockEngine {
            respond(
                content = fileAsText("poke/poke_list.json"),
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(engin) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        val service = PokeService(client)

        When("when") {
            val page = service.page(20, 0)

            Then("then") {
                page.count shouldBeExactly 1292
                page.data shouldHaveSize 20
            }
        }
    }
})
