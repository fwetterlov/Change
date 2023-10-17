package com.group8.change.ui.design

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopAppBar(
    content: @Composable () -> Unit,
    title: String,
    navController: NavController
) {
    val context = LocalContext.current
    // Scaffold required for formatting or something
    Scaffold(
        topBar = {
            // This topbar is center aligned (the text is in the center)
            CenterAlignedTopAppBar(
                // The title (text) of the topbar
                title = {
                    Text(text = title)

                },
                // This is the left aligned button (Home button)
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("main-menu")
                        },
                    ) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = Color.White)
                    }
                },
                // Here you adjust the colors of the topbar
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        // Here is where you put the additional contents of the app
        content = {
            Spacer(modifier = Modifier.height(60.dp))
            content()
        }
    )
}