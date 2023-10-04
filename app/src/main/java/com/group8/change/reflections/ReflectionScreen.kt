package com.group8.change.reflections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group8.change.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReflectionScreen() {
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
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
        }
    }
}


@Preview
@Composable
fun ReflectionsPreview() {
    ReflectionScreen()
}