package com.group8.change.expectations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.group8.change.api.models.CurrentUser
import com.group8.change.expectations.viewmodel.ExpectationsViewModel


@Composable
fun ExpectationsScreen(navController: NavController, expectationsViewModel: ExpectationsViewModel) {
    if (CurrentUser.data.role == "client") {
        ExpectationsClient(expectationsViewModel = expectationsViewModel, navController = navController )
    } else if (CurrentUser.data.role == "therapist") {
        ExpectationsTherapist(navController = navController)
    }
}