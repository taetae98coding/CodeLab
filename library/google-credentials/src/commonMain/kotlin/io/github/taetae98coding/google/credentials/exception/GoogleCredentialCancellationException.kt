package io.github.taetae98coding.google.credentials.exception

public class GoogleCredentialCancellationException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : GoogleCredentialException(message, cause)
