package com.group8.change.expectations

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.components.QuestionWithTextField
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.ui.design.TopAppBarPlus


@Composable
fun ExpectationsScreen(expectationsViewModel: ExpectationsViewModel, navController: NavController) {

        TopAppBarPlus(
            content = { QuestionWithTextField(expectationsViewModel) },
            title = stringResource(id = R.string.card_title_expectations),
            secondButton = { SubmitButton(expectationsViewModel, navController) },
            navController = navController)


}

@Composable
fun SubmitButton(expectationsViewModel: ExpectationsViewModel, navController: NavController) {
    Button(
        onClick = {
            Log.d("btnPress","${expectationsViewModel.questions.value}")
            navController.navigate("main-menu")
        }
    ) {
        Text(text = "Submit",
            color = Color.White)
    }

}


