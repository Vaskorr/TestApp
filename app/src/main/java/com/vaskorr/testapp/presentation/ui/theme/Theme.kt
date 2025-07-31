package com.vaskorr.testapp.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = Color(0xFF35304f),
    surface = Color(0xFF2a253d),
    primary = Color(0xFFAB3452),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF252138),
    error = Color(red = 179, green = 38, blue = 30),
    onSurfaceVariant = Color(0xFF87849B)
)

@Composable
fun TestAppTheme(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}