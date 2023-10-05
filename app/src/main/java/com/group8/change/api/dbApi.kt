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
import com.group8.change.api.sealed.MyDataState
import com.group8.change.api.viewmodel.MyViewModel


@Composable
fun GetUsers(viewModel: MyViewModel) {

    when (val result = viewModel.res.value) {

        is MyDataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator();
            }
        }
        is MyDataState.Success -> {
            DisplayList(result.data);
        }
        is MyDataState.Failure -> {
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
