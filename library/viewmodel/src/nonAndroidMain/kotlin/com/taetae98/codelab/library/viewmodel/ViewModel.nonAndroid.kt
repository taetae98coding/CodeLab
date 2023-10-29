package com.taetae98.codelab.library.viewmodel

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

public actual open class ViewModel : InstanceKeeper.Instance {
    public actual val viewModelScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun onDestroy() {
        viewModelScope.cancel()
    }
}
