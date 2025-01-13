package io.github.taetae98coding.codelab.core.poke.service.ext

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.curl.Curl

internal actual fun providesHttpClientEngine(): HttpClientEngine {
    return Curl.create()
}
