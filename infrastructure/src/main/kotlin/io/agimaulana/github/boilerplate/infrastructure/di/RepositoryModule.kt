package io.agimaulana.github.boilerplate.infrastructure.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.agimaulana.github.boilerplate.domain.api.repository.SampleUserRepository
import io.agimaulana.github.boilerplate.infrastructure.repository.SampleUserRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindSampleUserRepository(impl: SampleUserRepositoryImpl): SampleUserRepository
}
