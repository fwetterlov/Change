package com.group8.change.expectations.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExpectationsViewModel : ViewModel() {
    data class Question(
        val id: Int,
        val text: String,
        var answer: String = ""
    )

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    init {
        val initialQuestions = listOf(
            Question(1, "What is love?"),
            Question(2, "What is Something?"),
            Question(3, "What is time ?"),
            Question(4, "What is This ?"),
            Question(5, "What is That ?"),
            Question(6, "What are those ?"),

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
}