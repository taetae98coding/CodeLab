package com.taetae98.codelab.feature.poke

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.taetae98.codelab.navigation.core.poke.PokeEntry
import com.taetae98.codelab.navigation.core.poke.PokeListEntry

@Composable
public fun PokeEntry(modifier: Modifier = Modifier, entry: PokeEntry) {
    Children(
        modifier = modifier,
        stack = entry.stack,
        animation = stackAnimation(),
    ) {
        when (it.instance) {
            is PokeListEntry -> {
                Text(text = "Poke")
            }
        }
    }
}
