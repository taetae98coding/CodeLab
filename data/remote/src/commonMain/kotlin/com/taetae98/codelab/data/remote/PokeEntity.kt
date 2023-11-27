package com.taetae98.codelab.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokeEntity(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    private val url: String
) {
    val id: Int = url.substringBeforeLast("/")
        .substringAfterLast("/")
        .toInt()
}
