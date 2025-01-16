package io.github.taetae98coding.codelab.feature.poke.detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import io.github.taetae98coding.codelab.domain.poke.entity.PokeDetail

@Composable
internal fun PokeDetailDialog(
    onDismissRequest: () -> Unit,
    uiStateProvider: () -> PokeDetailUiState,
    modifier: Modifier = Modifier,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Surface(
            modifier = modifier,
            shape = AlertDialogDefaults.shape,
            color = AlertDialogDefaults.containerColor,
        ) {
            Content(uiStateProvider = uiStateProvider)
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun Content(
    uiStateProvider: () -> PokeDetailUiState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.size(400.dp)
            .padding(12.dp),
        contentAlignment = Alignment.Center,
    ) {
        when (val uiState = uiStateProvider()) {
            is PokeDetailUiState.Loading -> {
                CircularWavyProgressIndicator()
            }

            is PokeDetailUiState.State -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AsyncImage(
                        model = uiState.detail.thumbnail,
                        contentDescription = uiState.detail.name,
                        modifier = Modifier.size(200.dp),
                    )

                    StatBarColumn(
                        detail = uiState.detail,
                        modifier = Modifier.weight(1F),
                    )
                }
            }

            is PokeDetailUiState.Error -> {
                Button(onClick = uiState.retry) {
                    Text(text = "Retry")
                }
            }
        }
    }
}

@Composable
private fun StatBarColumn(
    detail: PokeDetail,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
    ) {
        StatBar(
            name = "HP",
            value = detail.hp,
            color = Color.Red,
            modifier = Modifier.fillMaxWidth(),
        )
        StatBar(
            name = "Attack",
            value = detail.attack,
            color = Color.Blue,
            modifier = Modifier.fillMaxWidth(),
        )
        StatBar(
            name = "Defense",
            value = detail.defense,
            color = Color.Green,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}


@Composable
private fun StatBar(
    name: String,
    value: Int,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Column {
        Text(text = name)
        Canvas(modifier = modifier.height(25.dp)) {
            val radius = CornerRadius(8.dp.toPx())

            drawRoundRect(
                color = Color.LightGray,
                cornerRadius = radius,
            )
            drawRoundRect(
                color = color,
                size = size.copy(width = size.width * value / 200),
                cornerRadius = radius,
            )
        }
    }
}
