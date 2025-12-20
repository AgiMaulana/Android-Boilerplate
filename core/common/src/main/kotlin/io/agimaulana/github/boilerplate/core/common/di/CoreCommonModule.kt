package io.agimaulana.github.boilerplate.core.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.agimaulana.github.boilerplate.core.common.DateTimeProvider
import io.agimaulana.github.boilerplate.core.common.DispatcherProvider
import io.agimaulana.github.boilerplate.core.common.internal.DateTimeProviderImpl
import io.agimaulana.github.boilerplate.core.common.internal.DefaultDispatcherProvider

@Module
@InstallIn(SingletonComponent::class)
object CoreCommonModule {

    @Provides
    fun provideDateTimeProvider(): DateTimeProvider = DateTimeProviderImpl()

    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()
}
