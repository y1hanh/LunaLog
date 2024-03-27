package com.example.a5046.presentation.report

import androidx.compose.material3.CardDefaults
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.a5046.R
import com.example.a5046.ui.theme.ForestGreen
import com.example.a5046.ui.theme.SoftGreen


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyPeriodTrackerTheme {
//// A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.onPrimary
//                ) {
//                    ReportScreen()
//
//                }
//            }
//        }
//    }
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Dashboard  \uD83C\uDF19", modifier =
        Modifier.padding(start = 16.dp), // Add padding to the title
            color = ForestGreen, // Set the text color
            fontSize = 20.sp, // Set the font size
            fontWeight = FontWeight.Bold // Set the text bold
        ) }) }
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(35.dp)) // Spacer to account for app bar height

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp),

                        ) {
                        item {
                            CardWithTitle(title = " Mood") {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.mood_doggie),
                                        contentDescription = "Daily Mood Image",
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .size(200.dp) // Adjust the size as needed
                                    )
                                    Text(text = "Feeling Happy", modifier = Modifier.padding(10.dp))
                                }
                            }
                        }
                        item {
                            CardWithTitle(title = "Your Period Starts in 5 days") {
                                Column (modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally){
                                    Text("Already started?")
                                    NoDataToDisplayText()
                                }
                            }
                        }

                        item {
                            CardWithTitle("Ovulation Prediction") {
// Content for Ovulation Prediction card
                                NoDataToDisplayText()
                            }
                        }


                        item {
                            CardWithTitle("Cycle Length") {
// Content for Cycle Length card
                                val data = remember { listOf(40f, 50f, 60f, 40f, 55f) } // Example data
                                val maxValue = remember { data.maxOrNull() ?: 0f }

                                BarChart(data, maxValue,
                                    Modifier
                                        .fillMaxWidth()
                                        .height(300.dp))
                            }
                        }
                        item {
                            CardWithTitle("Period Length") {
// Content for Period Length card
                                val data = remember { listOf(30f, 50f, 80f, 60f, 40f) } // Example data
                                val maxValue = remember { data.maxOrNull() ?: 0f }

                                BarChart(data, maxValue,
                                    Modifier
                                        .fillMaxWidth()
                                        .height(300.dp))
                            }
                        }
                        item {
                            CardWithTitle("Mood") {
// Content for Mood card
                                NoDataToDisplayText()
                            }
                        }
                        item {
                            CardWithTitle("Flow Tracker") {
// Content for Flow Tracker card
                                NoDataToDisplayText()
                            }
                        }


                        item {
                            CardWithPointChart(
                                title = "Energy level",
                                data = listOf(10f, 20f, 30f, 25f, 35f, 40f)
                            )
                        }

                    }}
    }
}

@Composable
fun CardWithTitle(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            ) {
            Text(
                title,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = SoftGreen, // Set the text color
                fontWeight = FontWeight.Bold // Set the text bold
            )
            content()
        }
    }
}


@Composable
fun NoDataToDisplayText() {
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "No Data to display",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            color = Color.Gray, // Set the text color
            fontSize = 16.sp // Set the font size
        )
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SoftGreen)
            ) {
            Text(text = "Log",
                fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun BarChart(
    data: List<Float>,
    maxValue: Float,
    modifier: Modifier = Modifier,
    barColor: Color = SoftGreen,
    borderColor: Color = ForestGreen,
    borderWidth: Float = 2f,
    barSpacing: Float = 8f, // Adjust spacing between bars as needed
    backgroundColor: Color = Color.White // Set background color

) {
    Canvas(modifier = modifier) {
// Draw background
        drawRect(
            color = backgroundColor,
            topLeft = Offset.Zero,
            size = size
        )
        val barCount = data.size
        val barWidth = (size.width - (barSpacing * (barCount - 1))) / barCount
        val maxBarHeight = size.height * 0.8f
        val unitHeight = maxBarHeight / maxValue

        data.forEachIndexed { index, value ->
            val barHeight = value * unitHeight
            val x = index * (barWidth + barSpacing)
            val y = size.height - barHeight

// Draw border
            drawRect(
                color = borderColor,
                topLeft = Offset(x, y),
                size = Size(barWidth, barHeight),
                style = Stroke(width = borderWidth)
            )

// Draw bar
            drawRect(
                color = barColor,
                topLeft = Offset(x + borderWidth / 2, y + borderWidth / 2),
                size = Size(barWidth - borderWidth, barHeight - borderWidth)
            )
        }
    }
}


@Composable
fun CardWithPointChart(title: String, data: List<Float>) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text(
                title,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = SoftGreen, // Set the text color
                fontWeight = FontWeight.Bold // Set the text bold
            )
            PointChart(data = data, modifier = Modifier.fillMaxWidth().height(200.dp))
        }
    }
}

@Composable
fun PointChart(
    data: List<Float>,
    modifier: Modifier = Modifier,
    pointColor: Color = SoftGreen,
    pointSize: Float = 8f,
    lineColor: Color = ForestGreen,
    lineWidth: Float = 2f
) {
    Canvas(modifier = modifier) {
        val maxX = size.width
        val maxY = size.height
        val unitX = maxX / (data.size - 1).toFloat()
        val maxData = data.maxOrNull() ?: 0f
        val unitY = maxY / maxData

// Draw lines
        drawLine(start = Offset(0f, maxY), end = Offset(maxX, maxY), color =
        lineColor, strokeWidth = lineWidth)
        drawLine(start = Offset(0f, 0f), end = Offset(0f, maxY), color =
        lineColor, strokeWidth = lineWidth)

// Draw points
        data.forEachIndexed { index, value ->
            val x = index * unitX
            val y = maxY - value * unitY
            drawCircle(color = pointColor, radius = pointSize, center = Offset(x, y))
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun PreviewReportScreen() {
//    ReportScreen()
//}