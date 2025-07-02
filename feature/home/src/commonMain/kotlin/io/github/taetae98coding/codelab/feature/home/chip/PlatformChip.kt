package io.github.taetae98coding.codelab.feature.home.chip

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.taetae98coding.codelab.compose.preview.CodeLabPreview
import io.github.taetae98coding.codelab.compose.theme.CodeLabTheme
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
internal fun PlatformChip(
    platform: Platform,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        border = AssistChipDefaults.assistChipBorder(true),
    ) {
        Text(
            text = platform.text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        )
    }
}

private class PlatformParameterPreview : PreviewParameterProvider<Platform> {
    override val values = sequenceOf(
        Platform.Android,
        Platform.IOS,
        Platform.Desktop,
        Platform.Web,
    )
}

@CodeLabPreview
@Composable
private fun Preview(
    @PreviewParameter(PlatformParameterPreview::class)
    platform: Platform,
) {
    CodeLabTheme {
        PlatformChip(platform = platform)
    }
}
