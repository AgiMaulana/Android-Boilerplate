package io.agimaulana.github.boilerplate.core.shared.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class SampleCustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Custom-Header", "CustomHeaderValue")
            .build()
        return chain.proceed(request)
    }
}
