package com.group8.change.selfassessment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.components.SelfAssessmentGraph
import com.group8.change.ui.design.TopAppBar


@Composable
fun TherapistSelfAssessment(navController: NavController) {

    TopAppBar(content = {
        Column(modifier = Modifier
            .padding(top = 60.dp)){
            SelfAssessmentGraph()
        }
        },
        title = stringResource(id = R.string.card_title_self_assessment),
        navController = navController)

}

