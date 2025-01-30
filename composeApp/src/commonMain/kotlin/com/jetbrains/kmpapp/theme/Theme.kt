package com.jetbrains.kmpapp.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    onPrimary = PurpleGrey80,
    primaryContainer = Color.White,
    surface = Color.White,
    onSurface = PurpleGrey80
)


@Composable
fun BeeShopTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
   /* val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isDarkTheme
        }
    }*/

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = Typography1
    )
}