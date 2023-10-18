package com.group8.change.evaluations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import com.group8.change.api.models.Evaluation
import com.group8.change.ui.design.TopAppBarPlus
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.components.TextFieldWithLabel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun morningEvaluation(navController: NavController) {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }

        TopAppBarPlus(content = {
            Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 56.dp)
        ) {
                Spacer(modifier = Modifier.height(90.dp))

            TextFieldWithLabel(
                labelText = stringResource(id = R.string.morning_title1),
                textValue = text1,
                onTextChange = { newValue -> text1 = newValue }
            )

            TextFieldWithLabel(
                labelText = stringResource(id = R.string.morning_title2),
                textValue = text2,
                onTextChange = { newValue -> text2 = newValue }
            )

            TextFieldWithLabel(
                labelText = stringResource(id = R.string.morning_title3),
                textValue = text3,
                onTextChange = { newValue -> text3 = newValue }
            )

        } }, title = stringResource(id = R.string.card_title_morning_evaluation),
            secondButton = { SubmitMorningEvaluation(navController = navController,text1,text2,text3) },
            navController = navController)

    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField(initialValue: String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf(initialValue) }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        modifier = Modifier.padding(top = 6.dp, bottom = 42.dp)
    )
}

/*
@Preview
@Composable
fun morningEvaluationPreview() {
    morningEvaluation()
}*/


@Composable
fun SubmitMorningEvaluation(navController: NavController, answer1: String, answer2: String, answer3: String) {
    Button(
        onClick = {
            val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val answerList = listOf(answer1, answer2, answer3)
            val newEvaluation = Evaluation(answerList, currentDate.toString())
            CurrentAppData.data.morning_evaluations.add(newEvaluation)
            DBApi.addChangesToDB(MainViewModel())
            navController.navigate("main-menu")
        }
    ) {
        Text(text = "Submit",
            color = Color.White)
    }
}
