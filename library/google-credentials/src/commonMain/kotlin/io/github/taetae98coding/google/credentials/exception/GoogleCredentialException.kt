package io.github.taetae98coding.google.credentials.exception

public open class GoogleCredentialException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause)
