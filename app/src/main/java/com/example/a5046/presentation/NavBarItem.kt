import com.example.a5046.R
import com.example.a5046.presentation.Routes

data class NavBarItem(
    val label: String = "",
    val icon: Int = R.drawable.ic_spaces,
    val iconSelected: Int = R.drawable.ic_spaces,
    val route: String = ""
) {
    fun NavBarItems(): List<NavBarItem> {
        return listOf(
            NavBarItem(
                label = "Dashboard",
                icon = R.drawable.ic_spaces,
                iconSelected = R.drawable.ic_spaces_filled,
                route = Routes.Report.value ),
            NavBarItem(
                label = "Main",
                icon = R.drawable.ic_home,
                iconSelected = R.drawable.ic_home_filled,
                route = Routes.Profile.value
            ),
            NavBarItem(
                label = "Settings",
                icon = R.drawable.ic_settings,
                iconSelected = R.drawable.ic_settings_filled,
                route = Routes.About.value
            ),
        )
    }
}