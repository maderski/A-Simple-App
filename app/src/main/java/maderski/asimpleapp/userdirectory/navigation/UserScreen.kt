package maderski.asimpleapp.userdirectory.navigation

sealed class UserScreen(val route: String) {
    object UserListScreen : UserScreen("user_list")
    object UserDetailScreen : UserScreen("user_detail")
    object UserLocationScreen : UserScreen("user_location")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
