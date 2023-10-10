package com.example.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


private val LightColors = lightColorScheme(
    primary = change_green,
    secondary = change_yellow,
    tertiary = change_blue,
    background = change_background
)


private val DarkColors = darkColorScheme(
    primary = change_green,
    secondary = change_yellow,
    tertiary = change_blue,
    background = change_background
)

@Composable
fun AppTheme(
  useDarkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {
  val colors = if (!useDarkTheme) {
    LightColors
  } else {
    DarkColors
  }

  MaterialTheme(
    colorScheme = colors,
    content = content
  )
}