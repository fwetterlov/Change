package com.group8.change.selfassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.group8.change.R
import com.group8.change.ui.design.TopAppBarPlus

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
        ) {
            SliderRow(stringResource(id = R.string.selfassessment_title1), selfImage.value)
            SliderRow(stringResource(id = R.string.selfassessment_title2), selfEsteem.value)
            SliderRow(stringResource(id = R.string.selfassessment_title3), selfConfidence.value)
        }
    }, title = stringResource(id = R.string.card_title_self_assessment),
        secondButton = { /*TODO*/ },
        navController = navController)

}

@Composable
fun SliderRow(label: String, sliderValue: Float) {
    var mutableSliderValue by remember { mutableStateOf(sliderValue) }

    Column {
        Text(
            text = label,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(end = 8.dp)
        )
        Slider(
            value = sliderValue,
            onValueChange = { newValue ->
                mutableSliderValue = newValue
            },
            valueRange = 0f..10f,
            steps = 9
        )
    }
}
