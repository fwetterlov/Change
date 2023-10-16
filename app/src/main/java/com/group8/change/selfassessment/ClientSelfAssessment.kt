package com.group8.change.selfassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClientSelfAssessment() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        SliderRow("Assessment 1")
        SliderRow("Assessment 2")
        SliderRow("Assessment 3")
    }
}

@Composable
fun SliderRow(label: String) {
    Column {
        Text(
            text = label,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(end = 8.dp)
        )
        Slider(
            value = 5f,
            onValueChange = { /* TODO */ },
            valueRange = 0f..10f,
            steps = 9
        )
    }
}
