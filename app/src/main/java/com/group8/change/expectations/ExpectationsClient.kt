package com.group8.change.expectations

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.DBApi
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.components.QuestionWithTextField
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.ui.design.TopAppBarPlus


@Composable
fun ExpectationsClient(expectationsViewModel: ExpectationsViewModel, navController: NavController) {

        TopAppBarPlus(
            content = {
                Column (   modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 56.dp)
                    .background(Color.White)){
                    Spacer(modifier = Modifier.height(90.dp))

                    QuestionWithTextField(expectationsViewModel)
                }

                      },
            title = stringResource(id = R.string.card_title_expectations),
            secondButton = { SubmitButton(expectationsViewModel, navController) },
            navController = navController)


}

@Composable
fun SubmitButton(expectationsViewModel: ExpectationsViewModel, navController: NavController) {
    Button(
        onClick = {
            Log.d("btnPress","${CurrentAppData.data.expectations}")
            val questions = expectationsViewModel.questions.value
            var counter = 0;

            for (question in questions){
                CurrentAppData.data.expectations.add(counter, question.answer)
                counter++
            }


            DBApi.addChangesToDB(MainViewModel())
            navController.navigate("main-menu")
        }
    ) {
        Text(text = "Submit",
            color = Color.White)
    }

}


