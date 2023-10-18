package com.group8.change.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun CardList(
    data: MutableList<String>,
    datesAndTimes: MutableList<String>,
    titles: List<String>,
    // Grades is optional!
    // Do not include if you don't have any!
    grades: MutableList<Int> = mutableListOf()
) {
    val dataSize = data.size
    val dateFormat: SimpleDateFormat

     if ("T" in datesAndTimes[0]) {
        // If both time and date are included
        dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    } else {
        // If only date is included
        dateFormat = SimpleDateFormat("yyyy-MM-dd")
    }

    Log.d("asd","Är det här?")

    Column(
        modifier = Modifier
            .padding(top = 60.dp)
    ) {
        ReflectionGraph()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(dataSize) {index ->

                val date: String
                var time = ""

                if ("T" in datesAndTimes[0]) {
                    // If both time and date are included
                    val fullDate = dateFormat.parse(datesAndTimes[index])
                    val (dateOnly, timeOnly) = formatDateTime(fullDate)

                    // Android studio made me do this
                    date = dateOnly
                    time = timeOnly
                } else {
                    // If only date is included
                    date = dateFormat.parse(datesAndTimes[index]).toString()
                }

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
                                text = date,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                            // Only visible when time is used
                            if ("T" in datesAndTimes[0]) {
                                // Time
                                Text(
                                    text = time
                                )
                            }
                            // Only visible when grades are used
                            if (grades.isNotEmpty()) {
                                //grades
                                Text(
                                    text = "Grade: ${grades[index]}"
                                )
                            }

                            if (titles.isNotEmpty()) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(400.dp)
                                ) {
                                    LazyColumn(
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        items(dataSize) { answerIndex ->
                                            Text(
                                                text = titles[answerIndex],
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                            Text(
                                                text = data[index],
                                                fontSize = 20.sp
                                            )
                                        }
                                    }
                                }
                            } else {
                                // Data
                                Text(
                                    text = data[index],
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun formatDateTime(date: Date): Pair<String, String> {
    val dateBlueprint = SimpleDateFormat("dd-MM-yyyy")
    val timeBlueprint = SimpleDateFormat("HH:mm")

    val dateOnly = dateBlueprint.format(date)
    val timeOnly = timeBlueprint.format(date)

    return Pair(dateOnly, timeOnly)
}