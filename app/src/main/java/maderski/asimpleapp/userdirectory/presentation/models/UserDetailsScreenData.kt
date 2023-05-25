package maderski.asimpleapp.userdirectory.presentation.models

data class UserDetailsScreenData(
    val userName: String,
    val name: String,
    val phone: String,
    val email: String,
    val imageUrl: String?
)