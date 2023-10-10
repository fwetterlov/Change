package com.group8.change.evaluations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group8.change.R
import com.group8.change.ui.design.TopAppBar

@Composable
fun eveningEvaluation() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    var text5 by remember { mutableStateOf("") }
    var text6 by remember { mutableStateOf("") }

        TopAppBar(content = {
            Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(90.dp))

            Text(
                modifier = Modifier.padding(horizontal = 64.dp),
                text = stringResource(id = R.string.evening_title1),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text1,
                onValueChange = { newValue -> text1 = newValue }
            )

            Text(
                text = stringResource(id = R.string.evening_title2),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text2,
                onValueChange = { newValue -> text2 = newValue }
            )

            Text(
                text = stringResource(id = R.string.evening_title3),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text3,
                onValueChange = { newValue -> text3 = newValue }
            )

            Text(
                text = stringResource(id = R.string.evening_title4),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text4,
                onValueChange = { newValue -> text4 = newValue }
            )

            Text(
                text = stringResource(id = R.string.evening_title5),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text5,
                onValueChange = { newValue -> text5 = newValue }
            )

            Text(
                text = stringResource(id = R.string.evening_title6),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text6,
                onValueChange = { newValue -> text6 = newValue }
            )

            Button(
                onClick = {

                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Submit")
            }

        } }, title = stringResource(id = R.string.card_title_evening_evaluation))

    }

@Preview
@Composable
fun eveningEvaluationPreview() {
    eveningEvaluation()
}