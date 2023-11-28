package com.taetae98.codelab.data.ktor.poke

import com.taetae98.codelab.data.dto.PokeDetailDto
import com.taetae98.codelab.data.dto.PokePageDto
import com.taetae98.codelab.data.ktor.HttpClientModule
import com.taetae98.codelab.data.remote.PokeRemoteDataSource
import com.taetae98.codelab.library.inject.KInject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named

@Factory
public class PokeRemoteDataSourceImpl @KInject internal constructor(
    @Named(HttpClientModule.POKE_CLIENT)
    @PokeHttpClient
    private val client: HttpClient
) : PokeRemoteDataSource {
    override suspend fun page(limit: Int, offset: Int): PokePageDto {
        val response = client.get("pokemon") {
            parameter("limit", limit)
            parameter("offset", offset)
        }

        return response.body<PokePageEntity>().toDto()
    }

    override suspend fun detail(id: Int): PokeDetailDto {
        val response = client.get("pokemon/$id")

        return response.body<PokeDetailEntity>().toDto()
    }
}
