package io.github.taetae98coding.codelab.core.poke.service

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

val pokePagingEngineModule = module {
    single<HttpClientEngine>(
        qualifier = StringQualifier(PokeHttpClientEngineModule.POKE_HTTP_CLIENT_ENGINE),
    ) {
        MockEngine { request ->
            val channel = ByteReadChannel(
                text = """
                        {
                          "count": 1302,
                          "next": "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
                          "previous": null,
                          "results": [
                            {
                              "name": "bulbasaur",
                              "url": "https://pokeapi.co/api/v2/pokemon/1/"
                            },
                            {
                              "name": "ivysaur",
                              "url": "https://pokeapi.co/api/v2/pokemon/2/"
                            },
                            {
                              "name": "venusaur",
                              "url": "https://pokeapi.co/api/v2/pokemon/3/"
                            },
                            {
                              "name": "charmander",
                              "url": "https://pokeapi.co/api/v2/pokemon/4/"
                            },
                            {
                              "name": "charmeleon",
                              "url": "https://pokeapi.co/api/v2/pokemon/5/"
                            },
                            {
                              "name": "charizard",
                              "url": "https://pokeapi.co/api/v2/pokemon/6/"
                            },
                            {
                              "name": "squirtle",
                              "url": "https://pokeapi.co/api/v2/pokemon/7/"
                            },
                            {
                              "name": "wartortle",
                              "url": "https://pokeapi.co/api/v2/pokemon/8/"
                            },
                            {
                              "name": "blastoise",
                              "url": "https://pokeapi.co/api/v2/pokemon/9/"
                            },
                            {
                              "name": "caterpie",
                              "url": "https://pokeapi.co/api/v2/pokemon/10/"
                            },
                            {
                              "name": "metapod",
                              "url": "https://pokeapi.co/api/v2/pokemon/11/"
                            },
                            {
                              "name": "butterfree",
                              "url": "https://pokeapi.co/api/v2/pokemon/12/"
                            },
                            {
                              "name": "weedle",
                              "url": "https://pokeapi.co/api/v2/pokemon/13/"
                            },
                            {
                              "name": "kakuna",
                              "url": "https://pokeapi.co/api/v2/pokemon/14/"
                            },
                            {
                              "name": "beedrill",
                              "url": "https://pokeapi.co/api/v2/pokemon/15/"
                            },
                            {
                              "name": "pidgey",
                              "url": "https://pokeapi.co/api/v2/pokemon/16/"
                            },
                            {
                              "name": "pidgeotto",
                              "url": "https://pokeapi.co/api/v2/pokemon/17/"
                            },
                            {
                              "name": "pidgeot",
                              "url": "https://pokeapi.co/api/v2/pokemon/18/"
                            },
                            {
                              "name": "rattata",
                              "url": "https://pokeapi.co/api/v2/pokemon/19/"
                            },
                            {
                              "name": "raticate",
                              "url": "https://pokeapi.co/api/v2/pokemon/20/"
                            }
                          ]
                        }
                    """.trimIndent(),
            )
            respond(
                content = channel,
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
            )
        }
    }
}
