package com.group8.change

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun eveningEvaluation() {
    Column (
        modifier = Modifier
            .background(Color.White)
    ){
        topBarWithLogo()
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kvällsutvärdering",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Det viktigaste som har hänt för mig idag är",
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = "Därför var det så viktigt för mig",
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = "Det kändes bra när jag",
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = "Idag är jag nöjd med",
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = "Idag är jag missnöjd med",
                style = TextStyle(fontSize = 16.sp)
            )

            textField()

            Text(
                text = "Idag är jag tacksam för",
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

        }


        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun eveningEvaluationPreview() {
    eveningEvaluation()
}