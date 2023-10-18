package com.group8.change.evaluations

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.components.CardList
import com.group8.change.ui.design.TopAppBar
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun morningEvaluationTherapist(navController: NavController) {

    val evaluations = CurrentAppData.data.morning_evaluations
    val evaluationsSize = evaluations.size
    val titleList = listOf(stringResource(id = R.string.morning_title1), stringResource(id = R.string.morning_title2), stringResource(id = R.string.morning_title3), "bla", "bla")

    val listOfData = mutableListOf<String>()
    val listOfDatesAndTimes = mutableListOf<String>()
    val listOfGrades = mutableListOf<Int>()

    var loopIndex = 0

    for (evaluation in evaluations) {
        listOfData.add(evaluation.answers[loopIndex])
        listOfDatesAndTimes.add(evaluation.date)
        loopIndex++
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
