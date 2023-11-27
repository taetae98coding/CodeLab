package com.taetae98.codelab.library.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

@Composable
public expect fun UriImage(modifier: Modifier = Modifier, uri: String, contentScale: ContentScale = ContentScale.Fit)
