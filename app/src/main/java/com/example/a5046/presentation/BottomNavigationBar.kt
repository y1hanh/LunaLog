package com.example.a5046.presentation.BottomNavigationBar

import NavBarItem
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a5046.R
import com.example.a5046.presentation.Routes
import com.example.a5046.presentation.SignInScreen
import com.example.a5046.presentation.main.mainpage.MainPageScreen
import com.example.a5046.presentation.report.ReportScreen
import com.example.a5046.presentation.settings.SettingsScreen


@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation (backgroundColor = MaterialTheme.colors.background ){
                val navBackStackEntry by
                navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                NavBarItem().NavBarItems().forEach { navItem ->
                    BottomNavigationItem(
                        icon = { Icon(
                            if (currentDestination?.route == navItem.route)
                                painterResource(navItem.iconSelected)
                            else
                                painterResource(navItem.icon)
                            ,
                            contentDescription = navItem.label,
                    )},
                        label = { Text(navItem.label) },
                        selected = currentDestination?.hierarchy?.any {
                            it.route == navItem.route
                        } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                // popUpTo is used to pop up to a given destination before navigating
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
//at most one copy of a given destination on the top of the back stack
                                launchSingleTop = true
// this navigation action should restore any state previously saved
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = Routes.Report.value,
            Modifier.padding(paddingValues)
        ) {
            composable(Routes.Report.value) {
                ReportScreen(navController)
            }
            composable(Routes.Profile.value) {
                MainPageScreen(navController)
            }
            composable(Routes.About.value) {
                SettingsScreen(navController)
            }
        }
    }
}
