package com.taetae98.codelab.feature.memo

internal sealed class MemoMessage {
    data object Upsert : MemoMessage()
}
