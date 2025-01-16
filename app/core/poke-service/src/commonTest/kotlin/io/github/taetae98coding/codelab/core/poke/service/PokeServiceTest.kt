package io.github.taetae98coding.codelab.core.poke.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.ksp.generated.module

class PokeServiceTest : FunSpec(), KoinComponent {
    init {
        test("Test paging") {
            startKoin {
                modules(
                    PokeServiceModule().module,
                    pokePagingEngineModule,
                )
            }

            val service by inject<PokeService>()
            val entity = service.paging(20, 0)

            entity.count shouldBe 1302
            entity.results.shouldHaveSize(20)
            entity.results.shouldForAll {
                it.name.shouldNotBeBlank()
                it.url.shouldNotBeBlank()
            }

            stopKoin()
        }

        test("Test getDetail") {
            startKoin {
                modules(
                    PokeServiceModule().module,
                    pokeDetailEngineModule,
                )
            }

            val service by inject<PokeService>()
            val entity = service.getDetail(2)

            entity.stats.shouldHaveSize(6)

            stopKoin()
        }
    }
}
