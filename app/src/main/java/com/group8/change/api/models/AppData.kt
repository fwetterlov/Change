package com.group8.change.api.models

data class AppData(
    var client: Client,
    var evening_evaluations: MutableList<Evaluation>,
    var expectations: MutableList<String>,
    var monthly_evaluations: MutableList<Evaluation>,
    var morning_evaluations: MutableList<Evaluation>,
    var reflections: MutableList<Reflection>,
    var selfassessment: MutableList<SelfAssessment>,
    var therapist: Therapist
){
    constructor() : this(Client("cli", "cli1"), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), Therapist("therap1"))
}

data class Client(
    val role: String,
    val username: String
){
    constructor() : this("", "")
}

data class Evaluation(
    var answers: List<String>,
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

data class SelfAssessment(
    val date: String,
    var grades: List<Int>
){
    constructor() : this("", emptyList())
}

data class Therapist(
    val username: String
){
    constructor() : this("")
}

object CurrentAppData {
    // singleton of AppData with some default values again!
    var data: AppData = AppData()
    var allData: List<AppData> = emptyList()

    fun update(newAppData: AppData) {
        data.client = newAppData.client
        data.evening_evaluations = newAppData.evening_evaluations
        data.expectations = newAppData.expectations
        data.monthly_evaluations = newAppData.monthly_evaluations
        data.morning_evaluations = newAppData.morning_evaluations
        data.reflections = newAppData.reflections
        data.selfassessment = newAppData.selfassessment
        data.therapist = newAppData.therapist
    }

}
