package com.group8.change.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun HistoricalDataButton(navController: NavController, route: String) {
    Box (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { navController.navigate(route) }) {
            Text(text = "History")
        }
    }
}