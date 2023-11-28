package com.taetae98.codelab.data.ktor.poke

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokePageEntity(
    @SerialName("count")
    val count: Int,
    @SerialName("results")
    val data: List<PokeEntity>
)
