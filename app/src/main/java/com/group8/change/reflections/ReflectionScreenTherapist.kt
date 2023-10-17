package com.group8.change.reflections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.group8.change.ui.design.TopAppBar

@Composable
fun ReflectionScreenTherapist() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBar(
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 60.dp)
                    ) {
                        Text(text = "hey")
                    }
                          },
                title = "Test"
            )
        }
    }
}

@Preview
@Composable
fun ReflectionPreview() {
    ReflectionScreenTherapist()
}