package com.group8.change.evaluations

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
fun eveningEvaluationTherapist() {

    val appData = CurrentAppData.data

    TopAppBar(content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(start = 56.dp)
        ) {
            Spacer(modifier = Modifier.height(90.dp))

            Text(
                text = appData.client.username,
                modifier = Modifier.padding(vertical = 24.dp),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )

            getAnswersEvening()

        }
    }, title = stringResource(id = R.string.card_title_morning_evaluation))
}
@Composable
fun getAnswersEvening() {

    val evaluations = CurrentAppData.data.evening_evaluations

    for (evaluation in evaluations) {
        val answers = evaluation.answers
        val date = evaluation.date

        for ((index, answer) in answers.withIndex()) {
            val dayNumber = index + 1
            showAnswers(answer = answer, date = date)
            println("Date: $date, Day $dayNumber - Answer: $answer")
        }
    }

}

/*
@Composable
fun topBarWithLogo() {
    // Denna ska bytas ut till Adams topBar
    Column(
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.change_logo2),
            contentDescription = "Change logga",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
    }
}*/


@Preview
@Composable
fun eveningEvaluationPreview() {
    morningEvaluationTherapist()
}
