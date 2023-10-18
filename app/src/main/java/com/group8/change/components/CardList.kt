package com.group8.change.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
    // Grades and datesAndTimes are optional!
    // Do not include if you don't have any!
    data: MutableList<String>,
    datesAndTimes: MutableList<String> = mutableListOf(),
    titles: List<String> = emptyList(),
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

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(dataSize) { index ->
            Column(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 10.dp,
                        start = 10.dp,
                        end = 10.dp
                    )
            ) {
                // Big card
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Card used for inner padding
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 10.dp,
                                bottom = 10.dp,
                                start = 10.dp,
                                end = 10.dp
                            )
                    ) {
                        // Why do i have to put this here???
                        // Used when dates are used
                        if (datesAndTimes.isNotEmpty()) {
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
                                val fullDate = dateFormat.parse(datesAndTimes[index])
                                date = formatDate(fullDate)
                            }

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
                        }
                        // Only visible when grades are used
                        if (grades.isNotEmpty()) {
                            //grades
                            Text(
                                text = "Grade: ${grades[index]}"
                            )
                        }

                        if (titles.isNotEmpty()) {
                            Text(
                                text = titles[index],
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = data[index],
                            fontSize = 20.sp
                        )

                        /*Box(
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
                        }*/
                    }
                }
            }
        }
    }

}

fun formatDate(date: Date): String {
    val dateBluePrint = SimpleDateFormat("dd-MM-yyyy")

    return dateBluePrint.format(date)
}

fun formatDateTime(date: Date): Pair<String, String> {
    val dateBlueprint = SimpleDateFormat("dd-MM-yyyy")
    val timeBlueprint = SimpleDateFormat("HH:mm")

    val dateOnly = dateBlueprint.format(date)
    val timeOnly = timeBlueprint.format(date)

    return Pair(dateOnly, timeOnly)
}