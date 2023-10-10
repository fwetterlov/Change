package com.group8.change.api

import android.util.Log
import androidx.compose.foundation.layout.*;
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.dp
import com.group8.change.api.models.AppData
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.CurrentUser
import com.group8.change.api.models.User
import com.group8.change.api.sealed.AppDataState
import com.group8.change.api.sealed.UserState
import com.group8.change.api.viewmodel.MainViewModel


object DBApi {


    fun login(viewModel: MainViewModel, username: String, password: String): User? {

        var userList: List<User>
        var appDataList: List<AppData>

        userList = emptyList()
        appDataList = emptyList()

        when (val result = viewModel.userState.value) {
            is UserState.Loading -> {}
            is UserState.Success -> {
                userList = result.data
            }
            is UserState.Failure -> {}
            else -> {}
        }

        val foundUser = userList.find { it.username == username && it.password == password }

        if(foundUser != null) {

            CurrentUser.update(foundUser) // set singleton CurrentUser!

            // also set singleton CurrentAppData
            //viewModel.fetchAppData();

            when (val result = viewModel.appDataState.value) {
                is AppDataState.Loading -> {}
                is AppDataState.Success -> {
                    appDataList = result.data
                }
                is AppDataState.Failure -> {}
                else -> {}
            }

            val foundAppData = appDataList.find { it.client.username == username }

            if(foundAppData != null) {

                println("HAPPY DAY")

                CurrentAppData.update(foundAppData) // set singleton CurrentAppData!

                println(CurrentAppData.data.client.username)

            }
            else println("AppData not found!")

        }

        return foundUser;

    }


    fun getUser(viewModel: MainViewModel) {

        when (val result = viewModel.userState.value) {
            is UserState.Loading -> {}
            is UserState.Success -> {
                logUserList(result.data);
            }
            is UserState.Failure -> {}
            else -> {}
        }

    }

    fun getAppData(viewModel: MainViewModel) {

        when (val result = viewModel.appDataState.value) {
            is AppDataState.Loading -> {}
            is AppDataState.Success -> {
                logAppDataList(result.data);
            }
            is AppDataState.Failure -> {}
            else -> {}
        }

    }

    fun logUserList(users: MutableList<User>) {
        for (user in users) {
            val userInfo = "User ID: ${user.password}, Name: ${user.role}, Age: ${user.username}"
            Log.d("UserList", userInfo)
        }
    }

    fun logAppDataList(appDataList: List<AppData>) {
        for (appData in appDataList) {
            println("Client: Role=${appData.client.role}, Username=${appData.client.username}")
            println("Evening Evaluations:")
            for (evaluation in appData.evening_evaluations) {
                println("  Date=${evaluation.date}")
                println("  Answers=${evaluation.answers.joinToString(", ")}")
            }
            println("Expectations: ${appData.expectations.joinToString(", ")}")
            println("Monthly Evaluations:")
            for (evaluation in appData.monthly_evaluations) {
                println("  Date=${evaluation.date}")
                println("  Answers=${evaluation.answers.joinToString(", ")}")
            }
            println("Morning Evaluations:")
            for (evaluation in appData.morning_evaluations) {
                println("  Date=${evaluation.date}")
                println("  Answers=${evaluation.answers.joinToString(", ")}")
            }
            println("Reflections:")
            for (reflection in appData.reflections) {
                println("  Data=${reflection.data}")
                println("  Datetime=${reflection.datetime}")
                println("  Grade=${reflection.grade}")
            }
            println("Therapist: Username=${appData.therapist.username}")
            println("---------------------------------")
        }
    }

    @Composable
    fun MyScreen(viewModel: MainViewModel) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    //getUser(viewModel)
                    //getAppData(viewModel)

                    println(login(viewModel, "client1", "1234"))
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Login (Hans)")
            }
            Button(
                onClick = {
                    viewModel.fetchAppData()
                    println("fetched datalito")
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Get (Hans)")
            }

        }

        when (val result = viewModel.userState.value) {

            is UserState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    //CircularProgressIndicator();
                }
            }

            is UserState.Success -> {
                //DisplayList(result.data);
            }

            is UserState.Failure -> {}
            else -> {}

        }

    }


}
