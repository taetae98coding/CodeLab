package com.taetae98.codelab.library.google.oauth

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
@Composable
public fun googleSignIn() {
    val uiViewController = LocalUIViewController.current

    GIDSignIn.sharedInstance.signInWithPresentingViewController(
        presentingViewController = uiViewController,
        completion = { result, error ->
            println("result $result -> error $error")
        }
    )
}
