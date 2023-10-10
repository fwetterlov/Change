package com.group8.change.api.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.group8.change.api.models.AppData
import com.group8.change.api.models.User
import com.group8.change.api.sealed.AppDataState
import com.group8.change.api.sealed.UserState


class MainViewModel : ViewModel() {

    val userState: MutableState<UserState> = mutableStateOf(UserState.Empty)
    val appDataState: MutableState<AppDataState> = mutableStateOf(AppDataState.Empty)

    init {
        fetchUserData()
        fetchAppData()
    }

    private fun fetchUserData() {
        val tempList = mutableListOf<User>()
        userState.value = UserState.Loading

        FirebaseDatabase.getInstance().getReference("Users")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {
                        val user = dataSnapshot.getValue(User::class.java)
                        if (user != null) {
                            tempList.add(user)
                        }
                    }
                    userState.value = UserState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    userState.value = UserState.Failure(error.message)
                }
            })
    }

    private fun fetchAppData() {
        val tempList = mutableListOf<AppData>()
        appDataState.value = AppDataState.Loading

        FirebaseDatabase.getInstance().getReference("AppData")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {
                        val appData = dataSnapshot.getValue(AppData::class.java)
                        if (appData != null) {
                            tempList.add(appData)
                        }
                    }
                    appDataState.value = AppDataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    appDataState.value = AppDataState.Failure(error.message)
                }
            })
    }
}
