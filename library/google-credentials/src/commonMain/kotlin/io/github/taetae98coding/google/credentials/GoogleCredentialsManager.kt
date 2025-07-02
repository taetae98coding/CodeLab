package io.github.taetae98coding.google.credentials

public interface GoogleCredentialsManager {
    public suspend fun getIdToken(options: GoogleCredentialsOptions): String
}
