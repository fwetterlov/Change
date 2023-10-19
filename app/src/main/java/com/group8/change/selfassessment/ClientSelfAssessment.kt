package com.group8.change.selfassessment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.group8.change.R
import com.group8.change.api.DBApi
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.SelfAssessment
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.components.HistoricalDataButton
import com.group8.change.reflections.SelectedPositionText
import com.group8.change.ui.design.TopAppBarPlus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ClientSelfAssessment(navController: NavHostController) {
    val selfImage = remember { mutableStateOf(5f) }
    val selfEsteem = remember { mutableStateOf(5f) }
    val selfConfidence = remember { mutableStateOf(5f) }

    TopAppBarPlus(content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
                .background(Color.White)
                .padding(16.dp)
        ) {
            HistoricalDataButton(navController = navController, route = "self-assessment-th")
            SliderRow(stringResource(id = R.string.selfassessment_title1), selfImage.value) {
                selfImage.value = it
            }
            SliderRow(stringResource(id = R.string.selfassessment_title2), selfEsteem.value) {
                selfEsteem.value = it
            }
            SliderRow(stringResource(id = R.string.selfassessment_title3), selfConfidence.value) {
                selfConfidence.value = it
            }
        }
    }, title = stringResource(id = R.string.card_title_self_assessment),
        secondButton = { SubmitSelfAssessment(navController, selfImage.value, selfEsteem.value, selfConfidence.value ) },
        navController = navController)

}

@Composable
fun SliderRow(label: String, sliderValue: Float, onSliderValueChanged: (Float) -> Unit) {
    Column {
        Text(
            text = label,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(end = 8.dp)
        )
        Slider(
            value = sliderValue,
            onValueChange = {
                onSliderValueChanged(it)
            },
            valueRange = 0f..10f,
            steps = 9
        )
        SelectedPositionText(sliderValue)
    }
}

@Composable
fun SubmitSelfAssessment(navController: NavController, selfImageValue: Float, selfEsteemValue: Float, selfConfidenceValue: Float) {
    Button(
        onClick = {
            val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val grades = listOf(selfImageValue.toInt(), selfEsteemValue.toInt(), selfConfidenceValue.toInt())
            val newSelfAssessment = SelfAssessment(currentDate, grades)

            CurrentAppData.data.selfassessment.add(newSelfAssessment)
            DBApi.addChangesToDB(MainViewModel())

            navController.navigate("main-menu")
        }
    ) {
        Text(text = "Submit",
            color = Color.White)
    }
}
