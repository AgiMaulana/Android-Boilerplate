package io.agimaulana.github.boilerplate.infrastructure.repository

import io.agimaulana.github.boilerplate.core.common.DispatcherProvider
import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser
import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser.Education
import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser.Education.Degree.BACHELOR
import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser.Education.Degree.DOCTORATE
import io.agimaulana.github.boilerplate.domain.api.entity.SampleUser.Education.Degree.MASTER
import io.agimaulana.github.boilerplate.domain.api.repository.SampleUserRepository
import io.agimaulana.github.boilerplate.infrastructure.api.SampleUserApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SampleUserRepositoryImpl @Inject constructor(
    private val sampleUserApi: SampleUserApi,
    private val dispatcherProvider: DispatcherProvider,
) : SampleUserRepository {
    override suspend fun getSampleUsers(): List<SampleUser> {
        return withContext(dispatcherProvider.io) {
//            val ignoreResult = sampleUserApi.getSampleUsers() // just for sampling purpose
            listOf(
                SampleUser(
                    id = "user-1",
                    name = "User 1",
                    email = "user1@androidacademy.ac.id",
                    isActive = true,
                    education = listOf(
                        Education(
                            institution = "Washington University",
                            degree = DOCTORATE,
                            field = "Computer Science",
                            year = 2010,
                        ),
                        Education(
                            institution = "Stanford University",
                            degree = MASTER,
                            field = "Computer Science",
                            year = 2005,
                        ),
                        Education(
                            institution = "Massachusetts Institute of Technology",
                            degree = BACHELOR,
                            field = "Computer Science",
                            year = 2002,
                        ),
                    )
                )
            )
        }
    }
}
