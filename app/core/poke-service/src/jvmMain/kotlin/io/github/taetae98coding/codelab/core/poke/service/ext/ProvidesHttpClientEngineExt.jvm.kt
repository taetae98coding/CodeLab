package io.github.taetae98coding.codelab.core.poke.service.ext

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

internal actual fun providesHttpClientEngine(): HttpClientEngine {
    return OkHttp.create()
}
