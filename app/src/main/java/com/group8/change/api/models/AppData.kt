package com.group8.change.api.models

data class AppData(
    val client: Client,
    val evening_evaluations: List<Evaluation>,
    val expectations: List<String>,
    val monthly_evaluations: List<Evaluation>,
    val morning_evaluations: List<Evaluation>,
    val reflections: List<Reflection>,
    val therapist: Therapist
){
    constructor() : this(Client("", ""), emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), Therapist(""))
}

data class Client(
    val role: String,
    val username: String
){
    constructor() : this("", "")
}

data class Evaluation(
    val answers: List<String>,
    val date: String
){
    constructor() : this(emptyList(), "")
}

data class Reflection(
    val data: String,
    val datetime: String,
    val grade: Int
){
    constructor() : this("", "", 0)
}

data class Therapist(
    val username: String
){
    constructor() : this("")
}
