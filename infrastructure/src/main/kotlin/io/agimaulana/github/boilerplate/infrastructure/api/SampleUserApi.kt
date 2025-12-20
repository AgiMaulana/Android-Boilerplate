package io.agimaulana.github.boilerplate.infrastructure.api

import retrofit2.http.GET

interface SampleUserApi {

    @GET("/users")
    suspend fun getSampleUsers()
}