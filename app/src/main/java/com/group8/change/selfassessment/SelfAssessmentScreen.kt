package com.group8.change.selfassessment

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.group8.change.api.models.CurrentUser

@Composable
fun SelfAssessmentScreen(navController: NavHostController) {
    if (CurrentUser.data.role == "client") {
        ClientSelfAssessment(navController)
    } else if (CurrentUser.data.role == "therapist") {
        TherapistSelfAssessment(navController)
    }
}