package com.group8.change.ui.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.example.compose.change_blue
import com.example.compose.change_yellow

@Composable
fun LinearGradient() {
    val gradient = Brush.linearGradient(
        0.3f to MaterialTheme.colorScheme.primary,
        0.5f to change_yellow,
        1.0f to change_blue,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient))
}