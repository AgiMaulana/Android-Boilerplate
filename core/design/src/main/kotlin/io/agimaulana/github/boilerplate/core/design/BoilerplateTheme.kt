package io.agimaulana.github.boilerplate.core.design

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

val LocalBoilerplateColors = compositionLocalOf { BoilerplateColors }

val LocalBoilerplateTypography = compositionLocalOf { BoilerplateTypography }

object BoilerplateTheme {
    val colors: BoilerplateColors
        @Composable
        get() = LocalBoilerplateColors.current

    val typography: BoilerplateTypography
        @Composable
        get() = LocalBoilerplateTypography.current
}
