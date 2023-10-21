package com.group8.change.evaluations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.DBApi
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.Evaluation
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.components.HistoricalDataButton
import com.group8.change.components.TextFieldWithLabel
import com.group8.change.ui.design.TopAppBarPlus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun eveningEvaluation(navController: NavController) {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    var text5 by remember { mutableStateOf("") }
    var text6 by remember { mutableStateOf("") }

    TopAppBarPlus(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.height(65.dp))
                HistoricalDataButton(navController = navController, route = "evening-th")
                Spacer(modifier = Modifier.height(10.dp))
                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.evening_title1),
                    textValue = text1,
                    onTextChange = { newValue -> text1 = newValue }
                )

                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.evening_title2),
                    textValue = text2,
                    onTextChange = { newValue -> text2 = newValue }
                )

                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.evening_title3),
                    textValue = text3,
                    onTextChange = { newValue -> text3 = newValue }
                )

                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.evening_title4),
                    textValue = text4,
                    onTextChange = { newValue -> text4 = newValue }
                )

                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.evening_title5),
                    textValue = text5,
                    onTextChange = { newValue -> text5 = newValue }
                )

                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.evening_title6),
                    textValue = text6,
                    onTextChange = { newValue -> text6 = newValue }
                )

            }
        }, title = stringResource(id = R.string.card_title_evening_evaluation),
        secondButton = {
            SubmitEveningEvaluation(
                navController = navController,
                text1,
                text2,
                text3,
                text4,
                text5,
                text6
            )
        },
        navController = navController
    )

}


/*
@Preview
@Composable
fun eveningEvaluationPreview() {
    eveningEvaluation(navController = )
}*/

@Composable
fun SubmitEveningEvaluation(
    navController: NavController,
    answer1: String,
    answer2: String,
    answer3: String,
    answer4: String,
    answer5: String,
    answer6: String
) {
    Button(
        onClick = {
            val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val answerList = listOf(answer1, answer2, answer3, answer4, answer5, answer6)
            val newEvaluation = Evaluation(answerList, currentDate.toString())
            CurrentAppData.data.evening_evaluations.add(newEvaluation)
            DBApi.addChangesToDB(MainViewModel())
            navController.navigate("main-menu")
        }
    ) {
        Text(
            stringResource(id = R.string.submit_button_text),
            color = Color.White
        )
    }
}