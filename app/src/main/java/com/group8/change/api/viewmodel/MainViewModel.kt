package com.group8.change.api.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.group8.change.api.models.User
import com.group8.change.api.sealed.DataState

class MainViewModel : ViewModel() {

    val res: MutableState<DataState> = mutableStateOf(DataState.Empty);

    init { fetchFirebaseData() }

    private fun fetchFirebaseData() {
        val tempList = mutableListOf<User>();
        res.value = DataState.Loading;
        FirebaseDatabase.getInstance().getReference("Users")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    for (DataSnap in snapshot.children) {
                        val usr = DataSnap.getValue(User::class.java);
                        if (usr != null)
                            tempList.add(usr);
                    }

                    res.value = DataState.Success(tempList);
                }

                override fun onCancelled(error: DatabaseError) {
                    res.value = DataState.Failure(error.message);
                }

            });
    }
}