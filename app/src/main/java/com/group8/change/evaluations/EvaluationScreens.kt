package com.group8.change.evaluations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.group8.change.api.models.CurrentUser


@Composable
fun MonthlyEvaluationScreen(navController: NavController) {
    if (CurrentUser.data.role == "client") {
        monthEvaluation(navController)
    } else if (CurrentUser.data.role == "client addiction") {
        MonthlyEvaluationAddiction(navController)
    } else if (CurrentUser.data.role == "therapist") {
        monthlyEvaluationTherapist(navController)
    }
}

@Composable
fun MorningEvaluationScreen(navController: NavController) {
    if (CurrentUser.data.role == "client"||CurrentUser.data.role == "client addiction") {
        morningEvaluation(navController = navController)
    } else if (CurrentUser.data.role == "therapist") {
        morningEvaluationTherapist(navController = navController)
    }
}

@Composable
fun EveningEvaluationScreen(navController: NavController) {
    if (CurrentUser.data.role == "client"||CurrentUser.data.role == "client addiction") {
        eveningEvaluation(navController = navController)
    } else if (CurrentUser.data.role == "therapist") {
        eveningEvaluationTherapist(navController = navController)
    }
}