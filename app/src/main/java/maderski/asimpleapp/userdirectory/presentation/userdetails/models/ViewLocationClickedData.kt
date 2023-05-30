package maderski.asimpleapp.userdirectory.presentation.userdetails.models

data class ViewLocationClickedData(
    val userId: String,
    val companyName: String,
    val latitude: String?,
    val longitude: String?
)
