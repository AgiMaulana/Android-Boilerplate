package io.agimaulana.github.boilerplate.domain.api.usecase

import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser

interface GetSampleUsersUseCase {
    suspend fun execute(): List<SampleUser>
}