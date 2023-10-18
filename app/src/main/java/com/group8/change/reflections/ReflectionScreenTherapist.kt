package com.group8.change.reflections

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.components.CardList
import com.group8.change.ui.design.TopAppBar

@Composable
fun ReflectionScreenTherapist(navController: NavController) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val reflections = CurrentAppData.data.reflections

            val listOfData = mutableListOf<String>()
            val listOfDatesAndTimes = mutableListOf<String>()
            val listOfGrades = mutableListOf<Int>()

            val listOfTitles = mutableListOf<String>()

            // Looping through the all data and adds it to separate lists
            for (reflection in reflections) {
                listOfData.add(reflection.data)
                listOfDatesAndTimes.add(reflection.datetime)
                listOfGrades.add(reflection.grade)
            }

            TopAppBar(
                content = {
                    // Only data and dateAndTime have to be sent
                    // grades is optional and can be left out
                    CardList(
                        data = listOfData,
                        datesAndTimes = listOfDatesAndTimes,
                        grades = listOfGrades,
                        titles = listOfTitles
                    )
                          },
                title = stringResource(id = R.string.card_title_reflections),
                navController = navController
            )
        }
    }
}