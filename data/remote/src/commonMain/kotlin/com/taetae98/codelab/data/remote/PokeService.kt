package com.taetae98.codelab.data.remote

import com.taetae98.codelab.library.inject.KInject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.core.annotation.Factory

@Factory
internal class PokeService @KInject constructor(
    private val client: HttpClient,
) {
    suspend fun page(limit: Int, offset: Int): PokePageEntity {
        val response = client.get("pokemon") {
            parameter("limit", limit)
            parameter("offset", offset)
        }

        return response.body()
    }
}