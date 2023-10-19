package com.group8.change.selfassessment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.group8.change.api.models.CurrentUser

@Composable
fun SelfAssessmentScreen(navController: NavHostController) {
    if (CurrentUser.data.role == "client"||CurrentUser.data.role == "client addiction") {
        ClientSelfAssessment(navController)
    } else if (CurrentUser.data.role == "therapist") {
        TherapistSelfAssessment(navController)
    }
}