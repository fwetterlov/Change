package com.group8.change.evaluations

import android.util.Log
import android.widget.NumberPicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.DBApi
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.Evaluation
import com.group8.change.api.models.SelfAssessment
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.components.HistoricalDataButton
import com.group8.change.components.TextFieldWithLabel
import com.group8.change.ui.design.TopAppBarPlus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MonthlyEvaluationAddiction(navController: NavController) {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var drugTestResult by remember { mutableStateOf("") }
    var aaMeetingsThisMonth by remember { mutableIntStateOf(0) }
    var relapse by remember { mutableStateOf("") }
    var daysSober by remember { mutableStateOf("") }
    var daysAbusing by remember { mutableStateOf("") }

    var showYesText by remember { mutableStateOf(false) }
    val yesString = stringResource(id = R.string.month_addiction_yes)

    TopAppBarPlus(content = {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color.White)
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.height(65.dp))
            HistoricalDataButton(navController = navController, route = "monthly-th")
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldWithLabel(
                labelText = stringResource(id = R.string.month_title1),
                textValue = text1,
                onTextChange = { newValue -> text1 = newValue }
            )

            TextFieldWithLabel(
                labelText = stringResource(id = R.string.month_title2),
                textValue = text2,
                onTextChange = { newValue -> text2 = newValue }
            )

            TextFieldWithLabel(
                labelText = stringResource(id = R.string.month_title3),
                textValue = text3,
                onTextChange = { newValue -> text3 = newValue }
            )

            Text(
                text = stringResource(id = R.string.month_addiction_title2),
                style = TextStyle(fontSize = 16.sp)
            )

            NumberPicker(aaMeetingsThisMonth, onValueChange = {newValue ->
                aaMeetingsThisMonth = newValue
            })

            Checkboxes(
                label = stringResource(id = R.string.month_addiction_title1),
                choice1 = stringResource(id = R.string.month_addiction_positive),
                choice2 = stringResource(id = R.string.month_addiction_negative),
                selectedChoice = drugTestResult,
                onChoiceSelected = { newChoice ->
                    drugTestResult = newChoice
                }
            )

            TextFieldWithLabel(
                labelText = stringResource(id = R.string.month_addiction_title3),
                textValue = daysSober,
                onTextChange = { newValue -> daysSober = newValue }
            )

            if (showYesText) {
                TextFieldWithLabel(
                    labelText = stringResource(id = R.string.month_addiction_title5),
                    textValue = daysAbusing,
                    onTextChange = { newValue -> daysAbusing = newValue }
                )
            }

            Checkboxes(
                label = stringResource(R.string.month_addiction_title4),
                choice1 = stringResource(id = R.string.month_addiction_yes),
                choice2 = stringResource(id = R.string.month_addiction_no),
                selectedChoice = relapse,
                onChoiceSelected = { newChoice ->
                    relapse = newChoice
                    showYesText = newChoice == yesString
                }
            )
        }
    }, title = stringResource(id = R.string.card_title_monthly_evaluation),
        secondButton = {
            SubmitMonthEvaluationAddiction(navController, text1, text2, text3, drugTestResult, aaMeetingsThisMonth, relapse, daysSober, daysAbusing)
        },
        navController = navController)
}

@Composable
fun Checkboxes(
    label: String,
    choice1: String,
    choice2: String,
    selectedChoice: String,
    onChoiceSelected: (String) -> Unit
) {
    Text(
        text = label,
        style = TextStyle(fontSize = 16.sp)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = selectedChoice == choice1,
            onCheckedChange = { isChecked ->
                if (isChecked) {
                    onChoiceSelected(choice1)
                }
            }
        )
        Text(choice1)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = selectedChoice == choice2,
            onCheckedChange = { isChecked ->
                if (isChecked) {
                    onChoiceSelected(choice2)
                }
            }
        )
        Text(choice2)
    }
}

@Composable
fun NumberPicker(
    value: Int,
    onValueChange: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { if (value > 0) onValueChange(value - 1) },
        ) {
            Text("-")
        }
        Text(
            text = value.toString(),
            modifier = Modifier.padding(8.dp),
            fontSize = 25.sp,
        )
        Button(
            onClick = { onValueChange(value + 1) },
        ) {
            Text("+")
        }
    }
}

@Composable
fun SubmitMonthEvaluationAddiction(navController: NavController, text1: String, text2: String, text3: String, drugTestResult: String, aaMeetingsThisMonth: Int, relapse: String, daysSober: String, daysAbusing: String) {
    Button(
        onClick = {
            val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val valueList = listOf(
                text1,
                text2,
                text3,
                drugTestResult,
                aaMeetingsThisMonth.toString(),
                relapse,
                daysSober,
                daysAbusing.ifEmpty { "0" }
            )
            val newMonthEvaluationAddiction = Evaluation(valueList, currentDate)

            CurrentAppData.data.monthly_evaluations.add(newMonthEvaluationAddiction)
            DBApi.addChangesToDB(MainViewModel())

            navController.navigate("main-menu")
            Log.d("MonthlyEvaluationAddiction", "Text1: $text1")
            Log.d("MonthlyEvaluationAddiction", "Text2: $text2")
            Log.d("MonthlyEvaluationAddiction", "Text3: $text3")
            Log.d("MonthlyEvaluationAddiction", "Drug Test Result: $drugTestResult")
            Log.d("MonthlyEvaluationAddiction", "AA Meetings This Month: $aaMeetingsThisMonth")
            Log.d("MonthlyEvaluationAddiction", "Relapse: $relapse")
            Log.d("MonthlyEvaluationAddiction", "Days Sober: $daysSober")
            Log.d("MonthlyEvaluationAddiction", "Days Abusing: $daysAbusing")

        }
    ) {
        Text(stringResource(id = R.string.submit_button_text),
            color = Color.White)
    }
}