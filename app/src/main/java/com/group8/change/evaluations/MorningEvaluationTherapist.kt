package com.group8.change.evaluations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.components.CardList
import com.group8.change.ui.design.TopAppBar

@Composable
fun morningEvaluationTherapist(navController: NavController) {

    val evaluations = CurrentAppData.data.morning_evaluations
    val titleList = listOf(
        stringResource(id = R.string.morning_title1),
        stringResource(id = R.string.morning_title2),
        stringResource(id = R.string.morning_title3),
        "bla",
        "bla"
    )

    val listOfData = mutableListOf<List<String>>()
    val listOfDatesAndTimes = mutableListOf<String>()


    for (evaluation in evaluations) {
        listOfData.add(evaluation.answers)
        listOfDatesAndTimes.add(evaluation.date)
    }

    TopAppBar(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp)
            ) {
                CardList(
                    data = listOfData,
                    datesAndTimes = listOfDatesAndTimes,
                    titles = titleList
                )
            }
        },
        title = stringResource(id = R.string.card_title_morning_evaluation), navController
    )
}

/*
@Preview
@Composable
fun morningEvaluationPreview() {
    morningEvaluationTherapist()
}

 */
