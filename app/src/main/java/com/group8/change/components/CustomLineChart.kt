package com.group8.change.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.group8.change.api.models.CurrentAppData
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.line.lineSpec
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import com.patrykandpatrick.vico.core.entry.FloatEntry
import com.patrykandpatrick.vico.core.entry.entryModelOf
import java.text.SimpleDateFormat

@Composable
private fun CustomLineChart(
    entryModel: ChartEntryModel,
    leftAxisValueFormatter: AxisValueFormatter<AxisPosition.Vertical.Start>,
    bottomAxisValueFormatter: AxisValueFormatter<AxisPosition.Horizontal.Bottom>) {

    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(
                    top = 20.dp,
                    bottom = 20.dp,
                    start = 10.dp,
                    end = 10.dp
                    )
        ) {


            Chart(
                modifier = Modifier.padding(8.dp),
                chart = lineChart(
                    lines = listOf(
                        lineSpec(
                            lineColor = Color.Green,
                            lineBackgroundShader = null
                        ),
                        lineSpec(
                            lineColor = Color.Blue,
                            lineBackgroundShader = null
                        ),
                        lineSpec(
                            lineColor = Color.Red,
                            lineBackgroundShader = null
                        )
                    ),
                ),
                model = entryModel,
                startAxis = rememberStartAxis(valueFormatter = leftAxisValueFormatter),
                bottomAxis = rememberBottomAxis(
                    guideline = null,
                    valueFormatter = bottomAxisValueFormatter
                )
            )

        }
    }
}

@Composable
fun ReflectionGraph() {

    val currentData = CurrentAppData.data.reflections
    val gradeList = ArrayList<FloatEntry>()
    val dateList = ArrayList<String>()

    var counter1 = 0f

    for (reflection in currentData) {
        val yFloat = reflection.grade.toFloat()
        val xDate = reflection.datetime

        gradeList.add(FloatEntry(x = counter1, y = yFloat))
        dateList.add(xDate)

        counter1 += 1f;
    }

    val chartEntryModel = entryModelOf(gradeList)

    val leftAxisValueFormatter = AxisValueFormatter<AxisPosition.Vertical.Start> { value, _ ->
        val intValue = value.toInt()
        val decimalPart = value - intValue
        if (decimalPart < 0.5) {
            intValue.toString()
        } else {
            (intValue + 1).toString()
        }
    }


    val bottomAxisValueFormatter =
        AxisValueFormatter<AxisPosition.Horizontal.Bottom> { x, _ ->
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateList.getOrNull(x.toInt()))
            date?.let {
                SimpleDateFormat("dd/MM").format(it)
            } ?: ""
        }

    CustomLineChart(
        entryModel = chartEntryModel,
        leftAxisValueFormatter = leftAxisValueFormatter,
        bottomAxisValueFormatter = bottomAxisValueFormatter)
}







@Composable
fun SelfAssessmentGraph() {

    val currentData = CurrentAppData.data.selfassessment

    val gradeList1 = ArrayList<FloatEntry>()
    val gradeList2 = ArrayList<FloatEntry>()
    val gradeList3 = ArrayList<FloatEntry>()
    val dateList = ArrayList<String>()
    var counter1 = 0f
    for (data in currentData) {

        val xDate = data.date
        gradeList1.add(FloatEntry(x = counter1, y = data.grades[0].toFloat()))
        gradeList2.add(FloatEntry(x = counter1, y = data.grades[1].toFloat()))
        gradeList3.add(FloatEntry(x = counter1, y = data.grades[2].toFloat()))

        dateList.add(xDate)
        counter1 += 1f;
    }

    val chartEntryModel = entryModelOf(gradeList1,gradeList2,gradeList3)

    val leftAxisValueFormatter = AxisValueFormatter<AxisPosition.Vertical.Start> { value, _ ->
        val intValue = value.toInt()
        val decimalPart = value - intValue
        if (decimalPart < 0.5) {
            intValue.toString()
        } else {
            (intValue + 1).toString()
        }
    }


    val bottomAxisValueFormatter = AxisValueFormatter<AxisPosition.Horizontal.Bottom> { x, _ ->
        val date = SimpleDateFormat("yyyy-MM-dd").parse(dateList.getOrNull(x.toInt()))
        date?.let {
            SimpleDateFormat("yyyy-MM-dd").format(it)
        } ?: ""
    }

    CustomLineChart(
        entryModel = chartEntryModel,
        leftAxisValueFormatter = leftAxisValueFormatter,
        bottomAxisValueFormatter = bottomAxisValueFormatter)

}


