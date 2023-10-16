package com.group8.change.selfassessment

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SelfAssessmentViewModel : ViewModel() {
    var selfImage by mutableStateOf(5f)
    var selfEsteem by mutableStateOf(5f)
    var selfConfidence by mutableStateOf(5f)
}