
package com.example.a5046.presentation.main.mainpage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a5046.presentation.util.Screen
import com.example.a5046.R
import com.example.a5046.presentation.main.components.SpaceRegularCard
import com.example.a5046.presentation.main.components.SpaceWideCard
//import com.mhss.app.mybrain.presentation.util.Screen
import com.example.a5046.ui.theme.*

@Composable
fun MainPageScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Luna Log",
                        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                    )
                },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            item {
                Row {
                    SpaceRegularCard(
                        modifier = Modifier.weight(1f, fill = true),
                        title = "Diary",
                        image = R.drawable.diary_img,
                        backgroundColor = LightGreen
                    ){
//                        navController.navigate(Screen.DiaryScreen.route)
                    }
                    SpaceRegularCard(
                        modifier = Modifier.weight(1f, fill = true),
                        title = "Mood",
                        image = R.drawable.emotional,
                        backgroundColor = SoftGreen
                    ){
//                        navController.navigate(Screen.BookmarksScreen.route)
                    }
                }
            }
            item {
                SpaceWideCard(
                    title = "Period",
                    image = R.drawable.period_tracking,
                    backgroundColor = WarmGreen
                ){
//                    navController.navigate(Screen.CalendarScreen.route)
                }
            }
            item { Spacer(Modifier.height(60.dp)) }
        }
    }
}

//@Preview
//@Composable
//fun SpacesScreenPreview() {
//    SpacesScreen(
//        navController = rememberNavController()
//    )
//}