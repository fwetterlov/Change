package com.group8.change.api

import android.util.Log
import androidx.compose.foundation.layout.*;
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;

import com.group8.change.api.models.User
import com.group8.change.api.sealed.DataState
import com.group8.change.api.viewmodel.MainViewModel


@Composable
fun GetUsers(viewModel: MainViewModel) {

    when (val result = viewModel.res.value) {

        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator();
            }
        }
        is DataState.Success -> {
            DisplayList(result.data);
        }
        is DataState.Failure -> {
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


fun DisplayList(users: MutableList<User>) {
    for (user in users) {
        val userInfo = "User ID: ${user.password}, Name: ${user.role}, Age: ${user.username}"
        Log.d("UserList", userInfo)
    }
}
