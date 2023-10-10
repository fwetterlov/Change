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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
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
                        text = stringResource(id = R.string.card_title_reflections)
                    )
                    // Second row left card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_morning_evaluation)
                    )
                }
                Column {
                    // First row right card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_expectations)
                    )
                    // Second row right card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_evening_evaluation)
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
                    text = stringResource(id = R.string.card_title_monthly_evaluation)
                )
            }
        }
    }
}