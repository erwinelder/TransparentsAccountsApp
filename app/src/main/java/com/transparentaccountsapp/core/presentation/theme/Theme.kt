package com.transparentaccountsapp.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp
import com.transparentaccountsapp.core.domain.AppTheme
import com.transparentaccountsapp.core.domain.WindowType

val LocalColors = compositionLocalOf<ColorPalette> { ColorPalette.Light }
val LocalWindowType = compositionLocalOf { WindowType.Compact }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransparentAccountsAppTheme(
    boxWithConstraintsScope: BoxWithConstraintsScope,
    appTheme: AppTheme? = null,
    content: @Composable () -> Unit
) {
    val colorPalette = if (appTheme == null) {
        val isSystemInDarkTheme = isSystemInDarkTheme()
        if (isSystemInDarkTheme) ColorPalette.Dark else ColorPalette.Light
    } else {
        when (appTheme) {
            AppTheme.Light -> ColorPalette.Light
            AppTheme.Dark -> ColorPalette.Dark
        }
    }

    val windowType = when {
        boxWithConstraintsScope.maxWidth < 600.dp -> WindowType.Compact
        boxWithConstraintsScope.maxWidth < 840.dp -> WindowType.Medium
        else -> WindowType.Expanded
    }

    CompositionLocalProvider(
        LocalColors provides colorPalette,
        LocalWindowType provides windowType,
        LocalRippleConfiguration provides null
    ) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}

val AppColors: ColorPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

val CurrWindowType: WindowType
    @Composable
    @ReadOnlyComposable
    get() = LocalWindowType.current
