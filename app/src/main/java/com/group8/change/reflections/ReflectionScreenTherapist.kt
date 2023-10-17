package com.group8.change.reflections

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.ui.design.TopAppBar

@Composable
fun ReflectionScreenTherapist(navController: NavController) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val reflections = CurrentAppData.data.reflections
            val reflectionsSize = reflections.size
            TopAppBar(
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 60.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            items(reflectionsSize) {index ->
                                // Splits the date and time into a list
                                val dateTime = reflections[index].datetime.split("T")
                                // Splits time into a list of h/m/s
                                val time = dateTime[1].split(":")
                                // Splits date into a list of y/m/d
                                val date = dateTime[0].split("-")
                                Column (
                                    modifier = Modifier
                                        .padding(
                                            top = 20.dp,
                                            bottom = 10.dp,
                                            start = 10.dp,
                                            end = 10.dp
                                        )
                                ) {
                                    // Big card
                                    Card (
                                        modifier = Modifier
                                            .fillMaxSize()
                                    ) {
                                        // Card used for inner padding
                                        Card (
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(
                                                    top = 10.dp,
                                                    bottom = 10.dp,
                                                    start = 10.dp,
                                                    end = 10.dp
                                                )
                                        ){
                                            // Date
                                            Text(
                                                text = "${date[2]}-${date[1]}-${date[0]}",
                                                fontSize = 30.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            // Time
                                            Text(
                                                text = "${time[0]}:${time[1]}"
                                            )
                                            // Data
                                            Text(
                                                text = "${reflections[index].data}",
                                                fontSize = 20.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                          },
                title = stringResource(id = R.string.card_title_reflections),
                navController = navController
            )
        }
    }
}