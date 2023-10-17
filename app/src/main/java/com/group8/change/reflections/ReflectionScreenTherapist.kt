package com.group8.change.reflections

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.group8.change.api.models.CurrentAppData
import com.group8.change.ui.design.TopAppBar

@Composable
fun ReflectionScreenTherapist() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val reflections = CurrentAppData.data.reflections
            val reflectionsSize = reflections.size
            TopAppBar(
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 60.dp)
                    ) {
                        LazyColumn() {
                            items(reflectionsSize) {index ->
                                Text(
                                    text = "${reflections[index].datetime}",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${reflections[index].data}",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "Grade: ${reflections[index].grade}",
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                          },
                title = "Test"
            )
        }
    }
}

@Preview
@Composable
fun ReflectionPreview() {
    ReflectionScreenTherapist()
}