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
        titleList.add("bla")
        titleList.add("bla")
    }

    val evaluations = CurrentAppData.data.monthly_evaluations
    val evaluationsSize = evaluations.size

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
                    items(evaluationsSize) {index ->

                        val formattedDate = SimpleDateFormat("dd-MM-yyyy").format(
                            SimpleDateFormat("yyyy-MM-dd").parse(evaluations[index].date) ?: Date()
                        )

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
                                        text = formattedDate,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(400.dp)
                                    ) {
                                        LazyColumn(
                                            modifier = Modifier.fillMaxSize()
                                        ) {
                                            items(evaluations[index].answers.size) { answerIndex ->
                                                Text(
                                                    text = titleList[answerIndex],
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold
                                                )

                                                Text(
                                                    text = evaluations[index].answers[answerIndex],
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