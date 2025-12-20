package io.agimaulana.github.boilerplate.core.shared.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.agimaulana.github.boilerplate.core.shared.interceptor.SampleCustomInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(
        interceptor: SampleCustomInterceptor
    ): Retrofit {
        val okHttpClient = okhttp3.OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://dummyjson.com/")
            .build()
    }

    @Provides
    fun provideSampleCustomInterceptor(): SampleCustomInterceptor {
        return SampleCustomInterceptor()
    }
}