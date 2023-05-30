package maderski.asimpleapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import maderski.asimpleapp.userdirectory.presentation.userlocation.UserMapLocationScreen
import maderski.asimpleapp.userdirectory.presentation.userdetails.UserDetailsScreen
import maderski.asimpleapp.userdirectory.presentation.userlist.UserListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNav.UserListScreen.route) {
        composable(ScreenNav.UserListScreen.route) {
            UserListScreen(navController = navController)
        }
        composable(ScreenNav.UserDetailScreen.route) {
            UserDetailsScreen()
        }
        composable(ScreenNav.UserLocationScreen.route) {
            UserMapLocationScreen()
        }
    }
}