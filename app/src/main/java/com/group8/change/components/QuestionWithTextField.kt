package com.group8.change.components


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.group8.change.expectations.viewmodel.ExpectationsViewModel


@Composable
fun QuestionWithTextField(
    viewModel: ExpectationsViewModel
) {
    val questions by viewModel.questions.collectAsState()

        LazyColumn() {
            items(questions) { question ->
                var answer by remember { mutableStateOf(question.answer) }
                TextFieldWithLabel(
                    labelText = question.text,
                    textValue = question.answer,
                    onTextChange = {
                        answer = it
                        viewModel.updateAnswer(question.id, it)
                    } )
        }
    }
}

