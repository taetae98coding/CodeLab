package io.github.taetae98coding.codelab.core.poke.service.ext

import io.ktor.client.engine.HttpClientEngine

internal expect fun providesHttpClientEngine(): HttpClientEngine
