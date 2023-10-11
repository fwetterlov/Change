package com.group8.change

import android.widget.Toast
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.group8.change.api.DBApi
import com.group8.change.api.sealed.AppDataState
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.ui.design.TopAppBar

// Composable for the home screen buttons
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardClickable(text: String, drawableId: Int, id: String, navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        // Defining how the cards look
        modifier = modifier
            .padding(10.dp)
            .width(140.dp)
            .height(140.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),   // Placeholder color
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = {
            when (id) {
                "Reflections" -> {
                    navController.navigate("reflections")
                }
                "Morning" -> {
                    navController.navigate("morning")
                }
                "Expectations" -> {
                    navController.navigate("expectations")
                }
                "Evening" -> {
                    navController.navigate("evening")
                }
                "Monthly" -> {
                    navController.navigate("monthly")
                }
            }
        }
        /*colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )*/
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

// Composable building the home screen
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController, viewModel: MainViewModel
) {

    TopAppBar(content = {
        when (val result = viewModel.appDataState.value) {

            is AppDataState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator();
                }
            }

            is AppDataState.Success -> {

                DBApi.setCurrentAppData(viewModel)   // set the singleton to current appData

                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    Column (
                        modifier = modifier.padding(top = 70.dp)
                    ) {
                        Row(
                        ) {
                            Column {
                                // First row left card
                                CardClickable(
                                    text = stringResource(id = R.string.card_title_reflections),
                                    id = "Reflections",
                                    drawableId = R.drawable.reflection,
                                    navController = navController
                                )
                                // Second row left card
                                CardClickable(
                                    text = stringResource(id = R.string.card_title_morning_evaluation),
                                    id = "Morning",
                                    drawableId = R.drawable.morning,
                                    navController = navController
                                )
                            }
                            Column {
                                // First row right card
                                CardClickable(
                                    text = stringResource(id = R.string.card_title_expectations),
                                    id = "Expectations",
                                    drawableId = R.drawable.expectation,
                                    navController = navController
                                )
                                // Second row right card
                                CardClickable(
                                    text = stringResource(id = R.string.card_title_evening_evaluation),
                                    id = "Evening",
                                    drawableId = R.drawable.evening,
                                    navController = navController
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
                                text = stringResource(id = R.string.card_title_monthly_evaluation),
                                id = "Monthly",
                                drawableId = R.drawable.month,
                                navController = navController
                            )
                        }
                    }
                }

            }
            is AppDataState.Failure -> {}
            else -> {}

        }
    },
        title = stringResource(id = R.string.app_name)
    )
}