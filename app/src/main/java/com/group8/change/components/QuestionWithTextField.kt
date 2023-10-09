package com.group8.change.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group8.change.R
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.ui.design.TopAppBarPlus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionWithTextField(
    viewModel: ExpectationsViewModel
) {
    val questions by viewModel.questions.collectAsState()
    TopAppBarPlus(content = { /*TODO*/ }, title = "Expectations Screen", ) {
        SubmitButton()
    }
    LazyColumn(modifier = Modifier.padding(60.dp)) {
        items(questions) { question ->
            var answer by remember { mutableStateOf(question.answer) }

                Text(
                    text = question.text,
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(16.dp)
                )
                TextField(
                    value = answer,
                    onValueChange = {
                        answer = it
                        viewModel.updateAnswer(question.id, it)
                    },
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp)
                        .fillMaxWidth()
                )
        }
    }
}


@Composable
fun SubmitButton() {
    Text(
        text = "Submit",
        modifier = Modifier.clickable { /* TODO */ }
    )

}