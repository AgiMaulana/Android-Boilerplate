package io.agimaulana.github.boilerplate.domain.api.repository

import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser

interface SampleUserRepository {
    suspend fun getSampleUsers(): List<SampleUser>
}
