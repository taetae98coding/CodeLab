package io.github.taetae98coding.google.credentials

public data object GoogleCredentialsSdk {
    private var serverClientId: String? = null

    public fun serverClientId(serverClientId: String): GoogleCredentialsSdk {
        this.serverClientId = serverClientId
        return this
    }

    internal fun getServerClientId(): String {
        return requireNotNull(serverClientId) {
            "GoogleCredentialsSdk.serverClientId() not called"
        }
    }
}
