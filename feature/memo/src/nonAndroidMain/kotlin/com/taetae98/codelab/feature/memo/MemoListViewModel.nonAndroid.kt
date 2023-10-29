package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.library.viewmodel.ViewModel
import kotlin.random.Random

internal actual class MemoListViewModel : ViewModel() {
    actual val randomInt: Int = Random.nextInt()
}