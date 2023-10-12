package com.group8.change.expectations.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.group8.change.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class ExpectationsViewModel(private val context: Context) : ViewModel() {
    data class Question(
        val id: Int,
        val text: String,
        var answer: String = ""
    )

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    fun loadQuestions() {
        val initialQuestions = listOf(
            Question(1, context.getString(R.string.expectations_title1)),
            Question(2, context.getString(R.string.expectations_title2)),
            Question(3, context.getString(R.string.expectations_title3)),
            Question(4, context.getString(R.string.expectations_title4)),
            Question(5, context.getString(R.string.expectations_title5)),
            Question(6, context.getString(R.string.expectations_title6)),
            Question(7, context.getString(R.string.expectations_title7)),
            Question(8, context.getString(R.string.expectations_title8)),
            Question(9, context.getString(R.string.expectations_title9)),
            Question(10, context.getString(R.string.expectations_title10))
        )
        _questions.value = initialQuestions
    }

    fun updateAnswer(questionId: Int, answer: String) {
        val updatedQuestions = questions.value.toMutableList()
        val questionIndex = updatedQuestions.indexOfFirst { it.id == questionId }
        if (questionIndex != -1) {
            updatedQuestions[questionIndex].answer = answer
            _questions.value = updatedQuestions
        }
    }

    fun createExpectationsQuestions() {
        loadQuestions()
    }
}