package com.group8.change.api.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class IsClickableViewModel: ViewModel() {
    var dropdownListAction: String by mutableStateOf("")


    fun updateDropdownListAction(action: String) {
        dropdownListAction = action
    }
}