package io.github.taetae98coding.codelab.core.poke.service.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PokeStatEntity(
    @SerialName("base_stat")
    val baseStat: Int,
    @SerialName("stat")
    val stat: Stat,
) {
    @Serializable
    public data class Stat(
        @SerialName("name")
        val name: String,
    )
}
