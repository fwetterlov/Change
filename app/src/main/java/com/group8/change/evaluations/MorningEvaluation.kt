package com.group8.change.evaluations

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group8.change.R
import com.group8.change.ui.design.TopAppBar

@Composable
fun morningEvaluation() {

        TopAppBar(content = {
            Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Spacer(modifier = Modifier.height(90.dp))

            Text(
                text = stringResource(id = R.string.morning_title1),
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = stringResource(id = R.string.morning_title2),
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = stringResource(id = R.string.morning_title3),
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Button(
                onClick = {

                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Submit")
            }

        } }, title = stringResource(id = R.string.card_title_morning_evaluation))

    }

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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.padding(28.dp)
    )
}

@Preview
@Composable
fun morningEvaluationPreview() {
    morningEvaluation()
}