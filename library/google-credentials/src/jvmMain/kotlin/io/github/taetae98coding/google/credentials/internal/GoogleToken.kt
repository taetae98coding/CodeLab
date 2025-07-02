package io.github.taetae98coding.google.credentials.internal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GoogleToken(
    @SerialName("id_token")
    val idToken: String,
)
