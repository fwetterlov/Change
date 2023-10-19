package com.group8.change.evaluations

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
fun monthlyEvaluationTherapist(navController: NavController) {

    val titleList = mutableListOf<String>()

    if (CurrentAppData.data.client.role == "client_addiction") {
        titleList.add(stringResource(id = R.string.month_title1))
        titleList.add(stringResource(id = R.string.month_title2))
        titleList.add(stringResource(id = R.string.month_title3))
        titleList.add(stringResource(id = R.string.month_addiction_title1))
        titleList.add(stringResource(id = R.string.month_addiction_title2))
        titleList.add(stringResource(id = R.string.month_addiction_title4))
        titleList.add(stringResource(id = R.string.month_addiction_title3))
        titleList.add(stringResource(id = R.string.month_addiction_title5))

    } else {
        titleList.add(stringResource(id = R.string.month_title1))
        titleList.add(stringResource(id = R.string.month_title2))
        titleList.add(stringResource(id = R.string.month_title3))
    }

    val evaluations = CurrentAppData.data.monthly_evaluations

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
        title = stringResource(id = R.string.card_title_monthly_evaluation), navController
    )
}

/*
@Preview
@Composable
fun monthlyEvaluationPreview() {
    monthlyEvaluationTherapist()
}

 */
