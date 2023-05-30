package maderski.asimpleapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            route = ScreenNav.UserDetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            UserDetailsScreen(userId = entry.arguments?.getString("id"), navController = navController)
        }
        composable(ScreenNav.UserLocationScreen.route) {
            UserMapLocationScreen()
        }
    }
}