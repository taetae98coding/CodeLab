package com.taetae98.codelab.feature.google.oauth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.compose.icon.NavigateUpIcon
import com.taetae98.codelab.library.google.oauth.compose.rememberGoogleOAuthLibrary

@Composable
internal fun GoogleOAuthScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavigateUp = onNavigateUp) }
    ) {
        Content(modifier = Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {

        },
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        }
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        val googleOauthLibrary = rememberGoogleOAuthLibrary()

        Box(
            modifier = Modifier.weight(1F),
        ) {

        }

        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = googleOauthLibrary::signIn,
        ) {
            Text(text = "SignIn")
        }
    }
}
