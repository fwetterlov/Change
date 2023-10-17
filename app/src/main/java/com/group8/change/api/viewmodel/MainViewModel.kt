package com.group8.change.api.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.group8.change.api.models.AppData
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.CurrentUser
import com.group8.change.api.models.Reflection
import com.group8.change.api.models.User
import com.group8.change.api.sealed.AppDataState
import com.group8.change.api.sealed.UserState


class MainViewModel : ViewModel() {

    val userState: MutableState<UserState> = mutableStateOf(UserState.Empty)
    val appDataState: MutableState<AppDataState> = mutableStateOf(AppDataState.Empty)

    init {
        fetchUserData()
        //fetchAppData()
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

    fun fetchAppData() {
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

    fun writeNewAppDataNode(){

        val newReflection = Reflection("RADICAL EVAL DATA", "2023-10-15T12:00:00", 9)

        //val indexToUpdate = 0
        //val appDataToUpdate = appDataList[indexToUpdate]
        val appDataToUpdate = CurrentAppData.data

        appDataToUpdate.reflections.add(newReflection)

        val databaseReference = FirebaseDatabase.getInstance().getReference("AppData")

        // for testing purposes
        databaseReference.child("client1").setValue(appDataToUpdate)


    }

    fun updateAppDataNode(){

        //val newReflection = Reflection("Testing hans shit", "2023-10-17T12:00:00", 8)
        //CurrentAppData.data.reflections.add(newReflection)
        val appDataToUpdate = CurrentAppData.data
        //appDataToUpdate.reflections.add(newReflection)

        //val clientUsername = "client1"

        val clientUsername = CurrentUser.data.username

        val databaseReference = FirebaseDatabase.getInstance().getReference("AppData")

        val query = databaseReference.orderByChild("client/username").equalTo(clientUsername)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // loop through the results (in this case, should be only one for the most part)
                    for (dataSnapshot in snapshot.children) {
                        val clientId = dataSnapshot.key

                        // reference the existing childnode and update data
                        val clientReference = databaseReference.child(clientId!!)
                        clientReference.setValue(appDataToUpdate)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // do stuff
            }
        })


    }

}
