package maderski.asimpleapp.navigation

import androidx.compose.runtime.State
import androidx.navigation.NavController

sealed interface NavigationEvent {
    object ToUserList : NavigationEvent
    data class ToUserDetails(val userId: String) : NavigationEvent
    data class ToUserMapLocation(
        val companyName: String,
        val latitude: String,
        val longitude: String,
    ) : NavigationEvent
}

fun State<NavigationEvent?>.navigateToDestination(navController: NavController) {
    this.value?.let { event ->
        when (event) {
            NavigationEvent.ToUserList -> navController.navigate(ScreenNav.UserListScreen.route)
            is NavigationEvent.ToUserDetails ->
                navController.navigate(ScreenNav.UserDetailScreen.withArgs(event.userId))
            is NavigationEvent.ToUserMapLocation ->
                navController.navigate(
                    ScreenNav.UserLocationScreen.withArgs(
                        event.companyName,
                        event.latitude,
                        event.longitude
                    )
                )

        }
    }
}