package com.group8.change.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group8.change.evaluations.textField

@Composable
fun TextFieldWithLabel(
    labelText: String,
    textValue: String,
    onTextChange: (String) -> Unit
) {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = labelText,
            style = TextStyle(fontSize = 16.sp)
        )

        textField(
            initialValue = textValue,
            onValueChange = { newValue ->
                onTextChange(newValue)
            })
    }
}