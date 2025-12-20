package io.agimaulana.github.boilerplate.domain.impl

import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser
import io.agimaulana.github.boilerplate.domain.api.repository.SampleUserRepository
import io.agimaulana.github.boilerplate.domain.api.usecase.GetSampleUsersUseCase
import javax.inject.Inject

class GetSampleUsersUseCaseImpl @Inject constructor(
    private val sampleUserRepository: SampleUserRepository
) : GetSampleUsersUseCase {
    override suspend fun execute(): List<SampleUser> {
        return sampleUserRepository.getSampleUsers()
    }
}
