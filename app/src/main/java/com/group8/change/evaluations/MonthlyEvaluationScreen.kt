package com.group8.change.evaluations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.group8.change.api.models.CurrentUser

@Composable
fun MonthlyEvaluationScreen(navController: NavController) {
    if (CurrentUser.data.role == "client") {
        Log.d("MonthlyEvaluationScreen", "Role: client")
        monthEvaluation(navController)
    } else if (CurrentUser.data.role == "client addiction") {
        Log.d("MonthlyEvaluationScreen", "Role: client addiction")
        MonthlyEvaluationAddiction(navController)
    } else if (CurrentUser.data.role == "therapist") {
        Log.d("MonthlyEvaluationScreen", "Role: therapist")
        monthlyEvaluationTherapist(navController)
    }
}