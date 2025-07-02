package io.github.taetae98coding.google.credentials.exception

public class GoogleCredentialsUnsupportedException(
    override val message: String? = "Not yet implemented",
    override val cause: Throwable? = null,
) : GoogleCredentialException(message, cause)
