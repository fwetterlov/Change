package com.group8.change.api.sealed

import com.group8.change.api.models.AppData

sealed class AppDataState {

    class Success(val data: MutableList<AppData>) : AppDataState();
    class Failure(val message: String) : AppDataState();
    object Loading : AppDataState();
    object Empty : AppDataState();

}
