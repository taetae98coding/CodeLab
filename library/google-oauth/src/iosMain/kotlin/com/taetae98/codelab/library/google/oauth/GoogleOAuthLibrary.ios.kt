package com.taetae98.codelab.library.google.oauth

import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
public actual class GoogleOAuthLibrary(
    private val uiViewController: UIViewController,
) {
    public actual fun signIn() {
        GIDSignIn.sharedInstance.signInWithPresentingViewController(
            presentingViewController = uiViewController,
            completion = { result, error ->
                println("$result -> $error")
            }
        )
    }

    public actual fun signOut() {
        GIDSignIn.sharedInstance.signOut()
    }
}