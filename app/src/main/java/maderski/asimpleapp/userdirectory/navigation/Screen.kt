package maderski.asimpleapp.userdirectory.navigation

sealed class Screen(val route: String) {
    object UserListScreen : Screen("user_list")
    object UserDetailScreen : Screen("user_detail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
