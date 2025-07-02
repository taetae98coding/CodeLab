package io.github.taetae98coding.google.credentials

public actual data class GoogleCredentialsOptions(
    val filterByAuthorizedAccounts: Boolean = false,
    val autoSelectEnabled: Boolean = false,
    val nonce: String? = null,
) {
    public actual companion object {
        public actual fun default(): GoogleCredentialsOptions {
            return GoogleCredentialsOptions()
        }
    }
}
