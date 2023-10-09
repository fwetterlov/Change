package com.group8.change.expectations

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.group8.change.components.QuestionWithTextField
import com.group8.change.expectations.viewmodel.ExpectationsViewModel



@Composable
fun ExpectationsScreen(expectationsViewModel: ExpectationsViewModel) {
    QuestionWithTextField(expectationsViewModel)
}

