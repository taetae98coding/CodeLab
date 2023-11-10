package com.taetae98.codelab.library.lifecycle

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

public actual open class KViewModel : InstanceKeeper.Instance {
    public actual val kViewModelScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun onDestroy() {
        super.onDestroy()
        kViewModelScope.cancel()
    }
}
