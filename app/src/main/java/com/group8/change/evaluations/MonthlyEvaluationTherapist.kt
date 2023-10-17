package com.group8.change.evaluations

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.ui.design.TopAppBar
import com.group8.change.ui.design.TopAppBarPlus
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun monthlyEvaluationTherapist(navController: NavController) {

    val appData = CurrentAppData.data
    val evaluations = CurrentAppData.data.monthly_evaluations
    val evaluationsSize = evaluations.size
    val titleList = listOf(stringResource(id = R.string.month_title1), stringResource(id = R.string.month_title2), stringResource(id = R.string.month_title3), "bla", "bla")

    Log.d("kajshd", evaluations[0].answers.size.toString())
    Log.d("kajshd", titleList.size.toString())
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
