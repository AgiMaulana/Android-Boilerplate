package io.agimaulana.github.boilerplate.domain.impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.agimaulana.github.boilerplate.domain.api.usecase.GetSampleUsersUseCase
import io.agimaulana.github.boilerplate.domain.impl.GetSampleUsersUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetSampleUsersUseCase(impl: GetSampleUsersUseCaseImpl): GetSampleUsersUseCase
}
