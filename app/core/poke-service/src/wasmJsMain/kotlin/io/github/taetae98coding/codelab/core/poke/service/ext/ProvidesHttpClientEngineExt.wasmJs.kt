package io.github.taetae98coding.codelab.core.poke.service.ext

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.js.Js

public actual fun providesHttpClientEngine(): HttpClientEngine {
    return Js.create()
}
