package maderski.asimpleapp.navigation

import maderski.asimpleapp.userdirectory.navigation.UserScreen

sealed class ScreenNavigation(val startDestination: String, val navRoute: String) {
    object UserDirectory : ScreenNavigation(
        startDestination = UserScreen.UserListScreen.route,
        navRoute = "user_directory"
    )
}