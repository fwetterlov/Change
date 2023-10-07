package com.group8.change.api.sealed

import com.group8.change.api.models.User

sealed class UserState {

    class Success(val data: MutableList<User>) : UserState();
    class Failure(val message: String) : UserState();
    object Loading : UserState();
    object Empty : UserState();

}
