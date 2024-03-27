package com.example.a5046.presentation.util

sealed class Screen(val route: String) {
    object SignUpScreen : Screen("sign_up_screen")
    object MainPageScreen : Screen("main_screen")
    object ReportScreen : Screen("report_screen")
    object SettingScreen : Screen("setting_screen")

}