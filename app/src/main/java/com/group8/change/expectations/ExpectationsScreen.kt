package com.group8.change.expectations

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.group8.change.components.QuestionWithTextField
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.ui.design.TopAppBarPlus


@Composable
fun ExpectationsScreen(expectationsViewModel: ExpectationsViewModel) {
    TopAppBarPlus(content = { /*TODO*/ }, title = "Expectations Screen", ) {
        SubmitButton()
    }
    QuestionWithTextField(expectationsViewModel)
}

@Composable
fun SubmitButton() {
    Text(
        text = "Submit",
        modifier = Modifier.clickable { /* TODO */ }
    )

}


