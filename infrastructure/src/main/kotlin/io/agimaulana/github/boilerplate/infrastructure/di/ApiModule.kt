package io.agimaulana.github.boilerplate.infrastructure.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.agimaulana.github.boilerplate.infrastructure.api.SampleUserApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideSampleUserApi(): SampleUserApi {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.restful-api.dev")
            .client(okHttpClient)
            .build()
        return retrofit.create(SampleUserApi::class.java)
    }
}