package maderski.asimpleapp.userdirectory.presentation.userlist.models

data class UserCardData(
    val id: Int,
    val name: String,
    val email: String,
    val imageUrl: String?,
    val onClick: (id: Int) -> Unit,
)