package com.group8.change.api.models

data class User(var password: String? = null, var role: String? = null, var username: String? = null)
object CurrentUser {
    // singleton of User with some default values
    val data: User = User("password1", "role1", "username1")

    fun update(newUser: User) {
        data.apply {
            password = newUser.password
            role = newUser.role
            username = newUser.username
        }
    }

}
