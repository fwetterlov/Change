package com.group8.change.expectations

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.group8.change.R
import com.group8.change.components.QuestionWithTextField
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.ui.design.TopAppBarPlus


@Composable
fun ExpectationsScreen(expectationsViewModel: ExpectationsViewModel) {

        TopAppBarPlus(content = { QuestionWithTextField(expectationsViewModel) }, title = stringResource(id = R.string.card_title_expectations)) {
            SubmitButton(expectationsViewModel)
        }


}

@Composable
fun SubmitButton(expectationsViewModel: ExpectationsViewModel) {
    Text(
        text = "Submit",
        modifier = Modifier.clickable { Log.d("btnPress", "${expectationsViewModel.questions.value}")}
    )

}


