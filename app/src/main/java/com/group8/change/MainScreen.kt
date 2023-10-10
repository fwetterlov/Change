package com.group8.change

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Composable for the home screen buttons
@Composable
fun CardClickable(text: String, modifier: Modifier = Modifier) {
    Card(
        // Defining how the cards look
        modifier = modifier
            .padding(20.dp)
            .width(150.dp)
            .height(150.dp)
            .background(MaterialTheme.colorScheme.background ),
        border = BorderStroke(2.dp, Color.Green),   // Placeholder color
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            // Centers the contents
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                // Text look and text alignment
                text = text,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

// Composable building the home screen
@Composable
fun Structure(
    text1: String,
    text2: String,
    text3: String,
    text4: String,
    text5: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
            ) {
                Column {
                    // First row left card
                    CardClickable(
                        text = text1
                    )
                    // Second row left card
                    CardClickable(
                        text = text3
                    )
                }
                Column {
                    // First row right card
                    CardClickable(
                        text = text2
                    )
                    // Second row right card
                    CardClickable(
                        text = text4
                    )
                }
            }
            // Used when an uneven number of clickables are used.
            // If number of clickables are even, add to previous columns
            // and comment this out.
            Column(
                modifier = modifier.align(Alignment.CenterHorizontally)
            ) {
                // Bottom most card
                CardClickable(
                    text = text5
                )
            }
        }
    }
}