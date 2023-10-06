package com.group8.change.expectations.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExpectationsViewModel : ViewModel() {

    private val _textInputState = MutableStateFlow("")
    val textInputState: StateFlow<String> = _textInputState

    fun setTextInputState(newText: String) {
        _textInputState.value = newText
    }
}