package io.github.taetae98coding.codelab.core.poke.service

import io.github.taetae98coding.codelab.core.poke.service.entity.PokeDetailEntity
import io.github.taetae98coding.codelab.core.poke.service.entity.PokePageResponseEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named

@Factory
public class PokeService internal constructor(
    @Named(PokeServiceModule.POKE_HTTP_CLIENT)
    private val client: HttpClient,
) {
    public suspend fun page(limit: Int, offset: Int): PokePageResponseEntity {
        val response = client.get("pokemon") {
            parameter("limit", limit)
            parameter("offset", offset)
        }

        return response.body<PokePageResponseEntity>()
    }

    public suspend fun getDetail(id: Int): PokeDetailEntity {
        val response = client.get("pokemon/$id")

        return response.body()
    }
}
