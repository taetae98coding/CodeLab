package com.taetae98.codelab.library.lifecycle

import kotlinx.coroutines.CoroutineScope

public expect open class KViewModel() {
    public val kViewModelScope: CoroutineScope
}
