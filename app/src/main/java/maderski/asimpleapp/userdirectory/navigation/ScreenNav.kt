package maderski.asimpleapp.userdirectory.navigation

sealed class ScreenNav(val route: String) {
    object UserListScreen : ScreenNav("user_list")
    object UserDetailScreen : ScreenNav("user_detail")
    object UserLocationScreen : ScreenNav("user_location")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
