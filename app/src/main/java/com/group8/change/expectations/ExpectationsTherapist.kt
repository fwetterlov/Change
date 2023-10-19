package com.group8.change.expectations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.group8.change.R
import com.group8.change.api.models.CurrentAppData
import com.group8.change.components.CardList
import com.group8.change.ui.design.TopAppBar

@Composable
fun ExpectationsTherapist(navController: NavController) {
    val expectations = CurrentAppData.data.expectations
    // List of titles
    val titles = listOf(
        stringResource(id = R.string.expectations_title1),
        stringResource(id = R.string.expectations_title2),
        stringResource(id = R.string.expectations_title3),
        stringResource(id = R.string.expectations_title4),
        stringResource(id = R.string.expectations_title5),
        stringResource(id = R.string.expectations_title6),
        stringResource(id = R.string.expectations_title7),
        stringResource(id = R.string.expectations_title8),
        stringResource(id = R.string.expectations_title9),
        stringResource(id = R.string.expectations_title10)
    )
    // Turning expectations into a 2D list where they will have index[0]
    // This is so it will work with CardList
    val listOfExpectations = mutableListOf(expectations)

    TopAppBar(
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 60.dp)
            ) {
                CardList(data = listOfExpectations, titles = titles)
            }
        },
        title = stringResource(id = R.string.card_title_expectations),
        navController = navController
    )
}