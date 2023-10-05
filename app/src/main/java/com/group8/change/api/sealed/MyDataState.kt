package com.group8.change.api.sealed

import com.group8.change.api.models.User

sealed class MyDataState {

    class Success(val data: MutableList<User>) : MyDataState();
    class Failure(val message: String) : MyDataState();
    object Loading : MyDataState();
    object Empty : MyDataState();

}
