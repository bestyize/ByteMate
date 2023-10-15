package com.thewind.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * @author: read
 * @date: 2023/8/25 上午12:09
 * @description:
 */


val LocalColors = staticCompositionLocalOf { dayThemeColors }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {

    val customColorsPalette = if (darkTheme) nightThemeColors
    else dayThemeColors
    CompositionLocalProvider(
        LocalColors provides customColorsPalette
    ) {
        MaterialTheme(
            content = content
        )
    }
}
