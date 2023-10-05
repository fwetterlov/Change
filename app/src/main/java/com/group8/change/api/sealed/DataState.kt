package com.group8.change.api.sealed

import com.group8.change.api.models.User

sealed class DataState {

    class Success(val data: MutableList<User>) : DataState();
    class Failure(val message: String) : DataState();
    object Loading : DataState();
    object Empty : DataState();

}
