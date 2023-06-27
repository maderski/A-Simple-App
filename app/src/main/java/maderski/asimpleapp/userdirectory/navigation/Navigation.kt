package maderski.asimpleapp.userdirectory.navigation

import androidx.activity.compose.BackHandler
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
            val userId = entry.arguments?.getString("id")
            UserDetailsScreen(userId = userId, navController = navController)
            BackHandler(enabled = true) {
                navController.navigate(ScreenNav.UserListScreen.route)
            }
        }
        composable(
            route = ScreenNav.UserLocationScreen.route + "/{id}/{companyName}/{lat}/{lng}"
        ) { entry ->
            UserMapLocationScreen(
                companyName = entry.arguments?.getString("companyName"),
                locationLat = entry.arguments?.getString("lat"),
                locationLng = entry.arguments?.getString("lng"),
            )
            BackHandler(enabled = true) {
                val id = entry.arguments?.getString("id")
                navController.navigate(ScreenNav.UserDetailScreen.route + "/$id")
            }
        }
    }
}