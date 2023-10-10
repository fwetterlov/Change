package com.group8.change.api.models

data class AppData(
    val client: Client,
    val eveningEvaluations: List<Evaluation>,
    val expectations: List<String>,
    val monthlyEvaluations: List<Evaluation>,
    val morningEvaluations: List<Evaluation>,
    val reflections: List<Reflection>,
    val therapist: Therapist
)

data class Client(
    val role: String,
    val username: String
)

data class Evaluation(
    val answers: List<String>,
    val date: String
)

data class Reflection(
    val data: String,
    val datetime: String,
    val grade: Int
)

data class Therapist(
    val username: String
)
