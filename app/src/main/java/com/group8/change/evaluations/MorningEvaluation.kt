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
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.ui.design.TopAppBar
import com.group8.change.ui.design.TopAppBarPlus

@Composable
fun morningEvaluation(navController: NavController) {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }

        TopAppBarPlus(content = {
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

            textField(
                initialValue = text1,
                onValueChange = { newValue -> text1 = newValue }
            )

            Text(
                text = stringResource(id = R.string.morning_title2),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text2,
                onValueChange = { newValue -> text2 = newValue }
            )

            Text(
                text = stringResource(id = R.string.morning_title3),
                style = TextStyle(fontSize = 16.sp)
            )

            textField(
                initialValue = text3,
                onValueChange = { newValue -> text3 = newValue }
            )

            Button(
                onClick = {

                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Submit")
            }

        } }, title = stringResource(id = R.string.card_title_morning_evaluation),
            secondButton = { SubmitMorningEvaluation(navController = navController) },
            navController = navController)

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField(initialValue: String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf(initialValue) }

    TextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        modifier = Modifier.padding(28.dp)
    )
}

/*
@Preview
@Composable
fun morningEvaluationPreview() {
    morningEvaluation()
}*/


@Composable
fun SubmitMorningEvaluation(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("main-menu")
        }
    ) {
        Text(text = "Submit",
            color = Color.White)
    }
}
