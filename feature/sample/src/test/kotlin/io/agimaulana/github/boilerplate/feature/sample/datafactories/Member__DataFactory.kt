package io.agimaulana.github.boilerplate.feature.sample.datafactories

import io.agimaulana.github.boilerplate.feature.sample.SampleViewModel

fun newUiStateMember(
    withName: String = "",
    withEmail: String = ""
) = SampleViewModel.UiState.Member(
    name = withName,
    email = withEmail
)