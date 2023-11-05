package com.taetae98.codelab.library.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

public actual open class KViewModel : ViewModel() {
    public actual val kViewModelScope: CoroutineScope = viewModelScope
}
