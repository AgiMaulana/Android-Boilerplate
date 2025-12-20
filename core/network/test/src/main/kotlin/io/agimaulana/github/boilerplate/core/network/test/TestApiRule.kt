package io.agimaulana.github.boilerplate.core.network.test

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import retrofit2.Retrofit
import kotlin.reflect.KClass

class TestApiRule : TestWatcher() {

    private val mockWebServer = MockWebServer()
    private lateinit var retrofit: Retrofit

    val baseUrl: String
        get() = mockWebServer.url(path = BASE_PATH).toString()

    override fun starting(description: Description) {
        retrofit = Retrofit.Builder().build()
    }

    override fun finished(description: Description) {
        mockWebServer.shutdown()
    }

    fun <T : Any> create(clazz: KClass<T>): T = retrofit.create(clazz.java)

    fun setResponse(responseCode: Int, data: String) {
        val response = MockResponse().apply {
            setResponseCode(responseCode)
            setBody(data)
        }
        mockWebServer.enqueue(response)
    }

    /**
     * Just can be called once per request
     */
    fun takeLastRequest(): Request {
        val request = mockWebServer.takeRequest()
        return Request(
            method = request.method,
            url = request.requestUrl?.toString(),
            path = request.requestUrl?.encodedPath,
            body = request.body.readUtf8(),
            queryParameters = request.requestUrl?.run {
                queryParameterNames.associateWith {
                    queryParameterValues(it).takeIf { q -> q.size > 1 }
                        ?: queryParameter(it)
                        ?: ""
                }
            } ?: emptyMap(),
            headers = request.headers.associate { it.first to it.second }
        )
    }

    data class Request(
        val method: String?,
        val url: String?,
        val path: String?,
        val body: String,
        val queryParameters: Map<String, Any>,
        val headers: Map<String, String>,
    )

    companion object {
        private const val BASE_PATH = "/"
    }
}