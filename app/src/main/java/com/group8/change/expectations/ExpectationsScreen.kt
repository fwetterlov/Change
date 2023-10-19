package com.group8.change.expectations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.CurrentUser
import com.group8.change.expectations.viewmodel.ExpectationsViewModel


@Composable
fun ExpectationsScreen(navController: NavController, expectationsViewModel: ExpectationsViewModel) {

    // Run the Therapist screen if the expectations are already submitted.
    if((CurrentUser.data.role == "client" || CurrentUser.data.role == "client addiction") && CurrentAppData.data.expectations[0].length >= 1 ){
        ExpectationsTherapist(navController = navController)
    } else if (CurrentUser.data.role == "client" || CurrentUser.data.role == "client addiction") {
        ExpectationsClient(expectationsViewModel = expectationsViewModel, navController = navController )
    } else if (CurrentUser.data.role == "therapist") {
        ExpectationsTherapist(navController = navController)
    }
}