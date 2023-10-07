package com.group8.change.api

import android.util.Log
import androidx.compose.foundation.layout.*;
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.dp
import com.group8.change.api.models.User
import com.group8.change.api.sealed.UserState
import com.group8.change.api.viewmodel.MainViewModel


@Composable
fun GetUsers(viewModel: MainViewModel) {

    when (val result = viewModel.userState.value) {

        is UserState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator();
            }
        }
        is UserState.Success -> {
            DisplayList(result.data);
        }
        is UserState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    //text = result.message,
                    text = "Error fetching firebase data!",
                    color = Color(0xFFAAAAAA)
                )
            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error Fetching data"
                )
            }
        }
    }
}


fun getUser(viewModel: MainViewModel) {

    when (val result = viewModel.userState.value) {

        is UserState.Loading -> {
        }
        is UserState.Success -> {
            DisplayList(result.data);
        }
        is UserState.Failure -> {
        }
        else -> {
        }

    }
}

fun DisplayList(users: MutableList<User>) {
    for (user in users) {
        val userInfo = "User ID: ${user.password}, Name: ${user.role}, Age: ${user.username}"
        Log.d("UserList", userInfo)
    }
}

@Composable
fun MyScreen(viewModel: MainViewModel) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                getUser(viewModel)
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Get")
        }

    }
}
