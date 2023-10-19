package com.group8.change.reflections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.components.CardList
import com.group8.change.components.ReflectionGraph
import com.group8.change.ui.design.TopAppBar

@Composable
fun ReflectionScreenTherapist(navController: NavController) {
    AppTheme {
        val reflections = CurrentAppData.data.reflections

        val listOfData = mutableListOf<String>()
        val listOfDatesAndTimes = mutableListOf<String>()
        val listOfGrades = mutableListOf<Int>()

        // Looping through the all data and adds it to separate lists
        for (reflection in reflections) {
            listOfData.add(reflection.data)
            listOfDatesAndTimes.add(reflection.datetime)
            listOfGrades.add(reflection.grade)
        }

        // Reverse the lists to have them appear in descending order
        val listOfDataRev = listOfData.asReversed()
        val listOfDatesAndTimesRev = listOfDatesAndTimes.asReversed()
        val listOfGradesRev = listOfGrades.asReversed()

        TopAppBar(
            content = {
                // Only data have to be sent
                // grades is optional and can be left out
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp)
                ) {
                    ReflectionGraph()
                    CardList(
                        data = listOfDataRev,
                        datesAndTimes = listOfDatesAndTimesRev,
                        grades = listOfGradesRev
                    )
                }

            },
            title = stringResource(id = R.string.card_title_reflections),
            navController = navController
        )
    }
}