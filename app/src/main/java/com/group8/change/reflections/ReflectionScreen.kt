package com.group8.change.reflections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group8.change.R
import com.group8.change.ui.theme.ChangeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReflectionScreen() {
    ChangeTheme {
        var textState by remember { mutableStateOf(TextFieldValue("")) }
        var sliderPosition by remember{ mutableStateOf(0f) }

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column (){
                Text(text = stringResource(id = R.string.card_title_reflections),
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(16.dp))
                TextField(
                    value = textState,
                    onValueChange = { newText ->
                        textState = newText
                    },
                    label ={ Text(text = stringResource(id = R.string.reflections_textbox))} ,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Gray)
                        .padding(16.dp)
                )
                Column (modifier = Modifier.padding(16.dp)){
                    ExperienceTexts()
                    Slider(
                        value = sliderPosition,
                        onValueChange = {sliderPosition = it},
                        valueRange= 0f..10f,
                        steps = 9
                    )
                    SelectedPositionText(sliderPosition)
                    SubmitButton(sliderPosition, textState.toString())
                }


            }
        }
    }

}

@Composable
fun ExperienceTexts() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Bad")
        Text(text = "Good")
    }
}


@Composable
fun SelectedPositionText(sliderPosition: Float) {
    val label = if (sliderPosition >= 1 && sliderPosition <= 2) {
        "Very bad"
    } else if (sliderPosition >= 3 && sliderPosition <= 4) {
        "Bad"
    } else if (sliderPosition.toInt() == 5) {
        "OK"
    } else if (sliderPosition >= 6 && sliderPosition <= 8) {
        "Good"
    } else if (sliderPosition >= 9 && sliderPosition <= 10) {
        "Very good"
    } else {
        ""
    }

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Text(
                text = label,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun SubmitButton(startPosition: Float, textState: String) {
    Button(modifier = Modifier.padding(), onClick = { /*TODO*/ }) {
        Text("Submit")
    }
}

@Preview
@Composable
fun ReflectionsPreview() {
    ReflectionScreen()
}