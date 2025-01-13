package io.github.taetae98coding.codelab.core.poke.service.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PokePageEntity(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    private val url: String,
) {
    val id: Int = url.substringBeforeLast("/")
        .substringAfterLast("/")
        .toInt()

    val thumbnail: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}
