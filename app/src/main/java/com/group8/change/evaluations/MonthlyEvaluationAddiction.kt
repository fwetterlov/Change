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
import com.group8.change.components.TextFieldWithLabel
import com.group8.change.ui.design.TopAppBarPlus

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
                .padding(start = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(90.dp))

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
            SubmitMonthEvaluationAddiction(navController, text1, text2, text3)
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
        modifier = Modifier.padding(top = 16.dp),
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
        modifier = Modifier.padding(top = 8.dp),
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
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Button(
            onClick = { if (value > 0) onValueChange(value - 1) },
        ) {
            Text("-")
        }
        Text(
            text = value.toString(),
            modifier = Modifier.padding(8.dp), // Add padding to the text
            fontSize = 25.sp, // Increase the font size
        )
        Button(
            onClick = { onValueChange(value + 1) },
        ) {
            Text("+")
        }
    }
}

@Composable
fun SubmitMonthEvaluationAddiction(navController: NavController, text1: String, text2: String, text3: String) {
    Button(
        onClick = {
            Log.d("monthaddiction", text1)
            Log.d("monthaddiction", text2)
            Log.d("monthaddiction", text3)
        }
    ) {
        Text(text = "Submit",
            color = Color.White)
    }
}