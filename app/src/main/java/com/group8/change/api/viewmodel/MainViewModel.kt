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

        // Create a Reflection object with the desired data, datetime, and grade values
        val newReflection = Reflection("RADICAL EVAL DATA", "2023-10-15T12:00:00", 9)

        // Find the specific AppData object in appDataList (you can use the index or any criteria)
        val indexToUpdate = 0  // Update the first AppData object, for example
        //val appDataToUpdate = appDataList[indexToUpdate]
        val appDataToUpdate = CurrentAppData.data

        // Add the new reflection to the reflections list of the AppData object
        appDataToUpdate.reflections.add(newReflection)

        // Now, you have updated the appDataList with the new reflection.

        // To write the updated data back to Firebase Realtime Database, you can use the following code.
        // This example assumes that the structure in the database matches your data classes.

        val databaseReference = FirebaseDatabase.getInstance().getReference("AppData")

        // Update the data at the specified database reference
        databaseReference.child("client1").setValue(appDataToUpdate)


    }

    fun updateAppDataNode(){

        val newReflection = Reflection("RADICAL EVAL DATA", "2023-10-15T12:00:00", 9)
        val appDataToUpdate = CurrentAppData.data
        appDataToUpdate.reflections.add(newReflection)

        val clientUsername = "client1" // Replace with the client's username you want to update

        val databaseReference = FirebaseDatabase.getInstance().getReference("AppData")

        // Query to find the existing child node with the specified username
        val query = databaseReference.orderByChild("client/username").equalTo(clientUsername)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // Loop through the results (in this case, there should be only one result)
                    for (dataSnapshot in snapshot.children) {
                        val clientId = dataSnapshot.key

                        // Reference the existing child node and update its data
                        val clientReference = databaseReference.child(clientId!!)
                        clientReference.setValue(appDataToUpdate)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })


    }

}
