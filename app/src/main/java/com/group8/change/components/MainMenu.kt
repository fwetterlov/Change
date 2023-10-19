package com.group8.change.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.CurrentUser
import com.group8.change.api.viewmodel.IsClickableViewModel
import com.group8.change.api.viewmodel.MainViewModel

// Composable for the home screen buttons
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardClickable(
    text: String,
    drawableId: Int,
    id: String,
    navController: NavController,
    isClickable: Boolean,
    modifier: Modifier = Modifier
) {

    val cardBackgroundColor = if (isClickable) {
        Color.White
    } else {
        Color.Gray.copy(alpha = 0.5f)
    }

    Card(
        // Defining how the cards look
        modifier = modifier
            .padding(10.dp)
            .width(140.dp)
            .height(140.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),   // Placeholder color
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = {
            if (isClickable) {
                navController.navigate(id)
            }
        },
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor
        )

    ) {
        Box(
            // Centers the contents
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(drawableId),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier.padding(top = 10.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
            )
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

// Composable building the main menu
@Composable
fun MainMenu(
    modifier: Modifier = Modifier,
    navController: NavController,
    clickableViewModel: IsClickableViewModel = remember{ IsClickableViewModel() },
    viewModel: MainViewModel
) {

    var routeIds = arrayOf(
        "reflections",
        "expectations",
        "morning",
        "evening",
        "monthly",
        "self-assessment"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier.padding(top = 70.dp)
        ) {
            // Used to gray/un-gray cards
            var isClickable by remember {
                mutableStateOf(false)
            }


            if (CurrentUser.data.role.toString() == "therapist") {
                Row {
                    CreateDropDownList(viewModel, clickableViewModel)
                }
            }

            // Updates isClickable when a client is selected from the list
            LaunchedEffect(clickableViewModel.dropdownListAction) {
                if (CurrentAppData.data.client.username != "cli1") {
                    isClickable = true
                }
            }

            Row {
                Column {
                    // First row left card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_reflections),
                        id = routeIds[0],
                        drawableId = R.drawable.reflection,
                        navController = navController,
                        isClickable = isClickable
                    )
                    // Second row left card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_morning_evaluation),
                        id = routeIds[2],
                        drawableId = R.drawable.morning,
                        navController = navController,
                        isClickable = isClickable
                    )
                    // Third row left card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_monthly_evaluation),
                        id = "monthly",
                        drawableId = R.drawable.month,
                        navController = navController,
                        isClickable = isClickable
                    )
                }
                Column {
                    // First row right card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_expectations),
                        id = routeIds[1],
                        drawableId = R.drawable.expectation,
                        navController = navController,
                        isClickable = isClickable
                    )
                    // Second row right card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_evening_evaluation),
                        id = routeIds[3],
                        drawableId = R.drawable.evening,
                        navController = navController,
                        isClickable = isClickable
                    )
                    // Third row right card
                    CardClickable(
                        text = stringResource(id = R.string.card_title_self_assessment),
                        id = routeIds[5],
                        drawableId = R.drawable.self,
                        navController = navController,
                        isClickable = isClickable
                    )
                }
            }
            /*
            // Used when an uneven number of clickables are used.
            // If number of clickables are even, add to previous columns
            // and comment this out.
            Column(
                modifier = modifier.align(Alignment.CenterHorizontally)
            ) {
                // Bottom most card
                CardClickable(
                    text = stringResource(id = R.string.card_title_monthly_evaluation),
                    id = "Monthly",
                    drawableId = R.drawable.month,
                    navController = navController
                )
            } */

        }
    }
}