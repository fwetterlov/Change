package com.group8.change.reflections

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.group8.change.api.models.CurrentUser


@Composable
fun ReflectionScreen(navController: NavController) {
    if (CurrentUser.data.role == "client" || CurrentUser.data.role == "client addiction") {
        ReflectionScreenClient(navController)
    } else if (CurrentUser.data.role == "therapist") {
        ReflectionScreenTherapist(navController)
    }
}