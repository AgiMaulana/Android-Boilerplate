package io.agimaulana.github.boilerplate.core.common.internal

import io.agimaulana.github.boilerplate.core.common.DateTimeProvider
import java.time.LocalDateTime
import java.time.ZoneId

internal class DateTimeProviderImpl : DateTimeProvider {
    override fun now(zoneId: ZoneId): LocalDateTime = LocalDateTime.now()
}
