package io.agimaulana.github.boilerplate.core.shared.test

import io.agimaulana.github.boilerplate.core.common.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestDispatcherProvider : DispatcherProvider {

    private val testDispatcher = UnconfinedTestDispatcher()

    override val main: CoroutineDispatcher
        get() = testDispatcher

    override val io: CoroutineDispatcher
        get() = testDispatcher

    override val default: CoroutineDispatcher
        get() = testDispatcher

    override val unconfined: CoroutineDispatcher
        get() = testDispatcher

    fun advanceTimeBy(delayTimeMillis: Long) {
        testDispatcher.scheduler.advanceTimeBy(delayTimeMillis)
    }

    fun advanceUntilIdle() {
        testDispatcher.scheduler.advanceUntilIdle()
    }
}
