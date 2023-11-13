package com.taetae98.codelab.data.remote

import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.koin.KoinExtension
import io.kotest.koin.KoinLifecycleMode
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeExactly
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.headersOf
import org.koin.dsl.module
import org.koin.ksp.generated.module
import org.koin.test.KoinTest
import org.koin.test.inject

class PokePageTest : BehaviorSpec(), KoinTest {
    override fun extensions(): List<Extension> {
        val modules = listOf(
            RemoteDataSourceModule().module,
            module {
                single<HttpClientEngine> {
                    MockEngine {
                        respond(
                            content = fileAsText("poke/poke_list.json"),
                            headers = headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }
                }
            },
        )

        return listOf(KoinExtension(modules, mockProvider = null, mode = KoinLifecycleMode.Root))
    }

    private val service by inject<PokeService>()

    init {
        Given("given") {
            When("when") {
                val page = service.page(20, 0)

                Then("then") {
                    page.count shouldBeExactly 1292
                    page.data shouldHaveSize 20
                }
            }
        }
    }
}
