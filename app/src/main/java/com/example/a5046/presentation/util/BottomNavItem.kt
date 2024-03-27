package com.example.a5046.presentation.util
import com.example.a5046.R
import com.example.a5046.presentation.util.Screen

sealed class BottomNavItem(val title: Int, val icon: Int, val iconSelected: Int, val route: String){

    object Report : BottomNavItem(R.string.report, R.drawable.ic_home, R.drawable.ic_home_filled, Screen.ReportScreen.route)
    object Main : BottomNavItem(R.string.main_page, R.drawable.ic_spaces, R.drawable.ic_spaces_filled, Screen.MainPageScreen.route)
    object Settings: BottomNavItem(R.string.settings, R.drawable.ic_settings, R.drawable.ic_settings_filled, Screen.SettingScreen.route)

}