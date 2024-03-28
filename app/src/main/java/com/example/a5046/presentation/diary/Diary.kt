package com.example.a5046.presentation.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a5046.R
import com.example.a5046.ui.theme.ForestGreen

@Composable
fun DiaryScreen(
//    navController: NavHostController,
//    viewModel: DiaryViewModel = hiltViewModel()
) {
    val uiState = { mutableStateOf(false) }
    var orderSettingsVisible by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Diary  \uD83C\uDF19",
                        modifier =
                        Modifier.padding(start = 16.dp),
                        color = ForestGreen,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp,
                actions = {
                    IconButton(onClick = {
//                        navController.navigate(Screen.DiaryChartScreen.route)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chart),
                            contentDescription = "Diary",
                            modifier = Modifier.size(34.dp)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
//                    navController.navigate(
//                        Screen.DiaryDetailScreen.route.replace(
//                            "{${Constants.DIARY_ID_ARG}}",
//                            "${-1}"
//                        )
//                    )
                },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    ) {
        PaddingValues ->
        Column {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { orderSettingsVisible = !orderSettingsVisible }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(R.drawable.ic_settings_sliders),
                        contentDescription = "Order By"
                    )
                }
                IconButton(onClick = {
//                    navController.navigate(Screen.DiarySearchScreen.route)
                }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search"
                    )
                }
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(12.dp)
        ){
            item{Spacer(modifier = Modifier.height(35.dp))}
            item{
                NoEntriesMessage()
            }
        }

    }
}




@Composable
fun NoEntriesMessage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Empty diaries? Time to fill them up! \n Click the + button and let the storytelling begin!",
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Image(
            modifier = Modifier.size(125.dp),
            painter = painterResource(id = R.drawable.empty_diary),
            contentDescription = "Empty diaries? Time to fill them up! \n Click the + button and let the storytelling begin!",
            alpha = 0.7f
        )
    }
}