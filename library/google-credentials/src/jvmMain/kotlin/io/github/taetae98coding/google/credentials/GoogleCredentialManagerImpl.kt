package io.github.taetae98coding.google.credentials

import io.github.taetae98coding.google.credentials.exception.GoogleCredentialException
import io.github.taetae98coding.google.credentials.exception.GoogleCredentialsUnsupportedException
import io.github.taetae98coding.google.credentials.internal.GoogleToken
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.DefaultJson
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.cio.CIO
import io.ktor.server.engine.EmbeddedServer
import io.ktor.server.engine.embeddedServer
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import java.awt.Desktop
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.json.Json

public class GoogleCredentialManagerImpl : GoogleCredentialsManager {
    private var server: EmbeddedServer<*, *>? = null

    override suspend fun getIdToken(options: GoogleCredentialsOptions): String {
        return suspendCancellableCoroutine { continuation ->
            try {
                if (Desktop.isDesktopSupported()) {
                    openBrowser()
                    runServer(
                        onSuccess = { idToken ->
                            continuation.resume(idToken)
                            stopServer()
                        },
                        onFail = {
                            continuation.resumeWithException(it)
                            stopServer()
                        },
                    )
                } else {
                    continuation.resumeWithException(GoogleCredentialsUnsupportedException())
                }
            } catch (throwable: Throwable) {
                runCatching {
                    stopServer()
                    continuation.resumeWithException(GoogleCredentialException(cause = throwable))
                }
            }

            continuation.invokeOnCancellation {
                stopServer()
            }
        }
    }

    private fun openBrowser() {
        val parameter = listOf(
            "response_type=code",
            "redirect_uri=${GoogleCredentialsSdk.getRedirectUri()}",
            "client_id=${GoogleCredentialsSdk.getClientId()}",
            "scope=${URLEncoder.encode("openid email profile", StandardCharsets.UTF_8)}",
        )
        val uri = URI("https://accounts.google.com/o/oauth2/v2/auth?${parameter.joinToString("&")}")

        Desktop.getDesktop().browse(uri)
    }

    private fun runServer(
        onSuccess: (String) -> Unit,
        onFail: (Throwable) -> Unit,
    ) {
        server = embeddedServer(factory = CIO, port = GoogleCredentialsSdk.getRedirectPort()) {
            routing {
                get {
                    val code = call.request.queryParameters["code"]

                    if (code == null) {
                        call.respondText(text = readHtml("no_code.html"), contentType = ContentType.Text.Html, status = HttpStatusCode.BadRequest)
                        onFail(GoogleCredentialException())
                    } else {
                        try {
                            val idToken = requestIdToken(code)

                            call.respondText(text = readHtml("success.html"), contentType = ContentType.Text.Html)
                            onSuccess(idToken)
                        } catch (throwable: Throwable) {
                            call.respondText(text = readHtml("failure.html"), contentType = ContentType.Text.Html, status = HttpStatusCode.InternalServerError)
                            onFail(GoogleCredentialException(cause = throwable))
                        }
                    }
                }
            }
        }.start(wait = false)
    }

    private suspend fun requestIdToken(code: String): String {
        val json = Json(DefaultJson) {
            ignoreUnknownKeys = true
        }
        val client = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(json)
            }
        }
        val response = client.post("https://oauth2.googleapis.com/token") {
            setBody(
                FormDataContent(
                    parameters {
                        append("code", code)
                        append("client_id", GoogleCredentialsSdk.getClientId())
                        append("client_secret", GoogleCredentialsSdk.getClientSecret())
                        append("redirect_uri", GoogleCredentialsSdk.getRedirectUri())
                        append("grant_type", "authorization_code")
                    },
                ),
            )
        }

        return response.body<GoogleToken>().idToken
    }

    private fun readHtml(
        name: String,
    ): String {
        val text = javaClass.classLoader.getResourceAsStream(name)
            ?.bufferedReader()
            ?.readText()

        return requireNotNull(text) { "Resource $name not found" }
    }

    private fun stopServer() {
        server?.engine?.stop()
        server?.stop()
        server = null
    }
}
