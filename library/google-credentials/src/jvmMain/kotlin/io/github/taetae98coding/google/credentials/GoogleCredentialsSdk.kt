package io.github.taetae98coding.google.credentials

public data object GoogleCredentialsSdk {
    private var redirectPort: Int? = null
    private var redirectUri: String? = null
    private var clientId: String? = null
    private var clientSecret: String? = null

    public fun redirectUri(redirectUri: String): GoogleCredentialsSdk {
        redirectPort = redirectUri.substringAfter("://")
            .substringAfter(":")
            .substringBefore("?")
            .substringBefore("/")
            .toIntOrNull()

        this.redirectUri = redirectUri
        return this
    }

    public fun clientId(clientId: String): GoogleCredentialsSdk {
        this.clientId = clientId
        return this
    }

    public fun clientSecret(clientSecret: String): GoogleCredentialsSdk {
        this.clientSecret = clientSecret
        return this
    }

    internal fun getRedirectPort(): Int {
        return requireNotNull(redirectPort) {
            "GoogleCredentialsSdk.redirectUri() not called or invalid"
        }
    }

    internal fun getRedirectUri(): String {
        return requireNotNull(redirectUri) {
            "GoogleCredentialsSdk.redirectUri() not called"
        }
    }

    internal fun getClientId(): String {
        return requireNotNull(clientId) {
            "GoogleCredentialsSdk.clientId() not called"
        }
    }

    internal fun getClientSecret(): String {
        return requireNotNull(clientSecret) {
            "GoogleCredentialsSdk.clientSecret() not called"
        }
    }
}
