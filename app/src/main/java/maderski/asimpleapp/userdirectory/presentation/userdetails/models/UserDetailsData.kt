package maderski.asimpleapp.userdirectory.presentation.userdetails.models

data class UserDetailsData(
    val userName: String,
    val name: String,
    val phone: String,
    val email: String,
    val imageUrl: String?
)