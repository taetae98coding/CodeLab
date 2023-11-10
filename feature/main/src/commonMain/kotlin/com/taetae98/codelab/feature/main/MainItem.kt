package com.taetae98.codelab.feature.main

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainItem(modifier: Modifier = Modifier, title: String, platformList: ImmutableList<Platform> = persistentListOf(), description: String? = null, onClick: () -> Unit) {
    Card(
        modifier = modifier,
        onClick = onClick,
    ) {
        Content(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            title = title,
            platformList = platformList,
            description = description,
        )
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier, title: String, platformList: ImmutableList<Platform>, description: String?) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Title(title = title)
        PlatformList(platformList = platformList)
        Description(description = description)
    }
}

@Composable
private fun Title(modifier: Modifier = Modifier, title: String) {
    if (title.isNotEmpty()) {
        Text(
            modifier = modifier,
            text = title,
            maxLines = 1,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun PlatformList(modifier: Modifier = Modifier, platformList: ImmutableList<Platform>) {
    if (platformList.isNotEmpty()) {
        FlowRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            platformList.forEach {
                Text(
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = CircleShape,
                    ).padding(4.dp),
                    text = it.name,
                )
            }
        }
    }
}

@Composable
private fun Description(modifier: Modifier = Modifier, description: String?) {
    if (description != null) {
        Text(
            modifier = modifier,
            text = description,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}
