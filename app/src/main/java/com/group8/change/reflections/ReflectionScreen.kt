package com.group8.change.reflections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.group8.change.R

@Composable
fun ReflectionScreen() {
    Surface (
        modifier = Modifier.fillMaxSize()){
        Column {
            Text(text = stringResource(id = R.string.card_title_reflections))
            Text(text = stringResource(id = R.string.reflections_title))
        }
    }
}