package maderski.asimpleapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import maderski.asimpleapp.userdirectory.presentation.userlocation.UserMapLocationScreen
import maderski.asimpleapp.userdirectory.navigation.UserScreen
import maderski.asimpleapp.userdirectory.presentation.userdetails.UserDetailsScreen
import maderski.asimpleapp.userdirectory.presentation.userlist.UserListScreen
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserListScreenData

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = UserScreen.UserListScreen.route) {
        navigation(
            startDestination = ScreenNavigation.UserDirectory.startDestination,
            route = ScreenNavigation.UserDirectory.navRoute,
        ) {
            composable(UserScreen.UserListScreen.route) {
                UserListScreen(data = UserListScreenData(cardListData = emptyList()))
            }
            composable(UserScreen.UserDetailScreen.route) {
                UserDetailsScreen()
            }
            composable(UserScreen.UserLocationScreen.route) {
                UserMapLocationScreen()
            }
        }
    }
}