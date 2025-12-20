package io.agimaulana.github.boilerplate.infrastructure.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetSampleUserRequest(
    @Json(name = "country")
    val country: String,
    @Json(name = "city")
    val city: String,
) {

    companion object {
        fun create(city: String): GetSampleUserRequest {
            return GetSampleUserRequest(
                country = "us",
                city = city,
            )
        }
    }
}
