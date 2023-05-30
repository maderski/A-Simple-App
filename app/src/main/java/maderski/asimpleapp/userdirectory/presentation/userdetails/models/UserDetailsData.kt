package maderski.asimpleapp.userdirectory.presentation.userdetails.models

data class UserDetailsData(
    val userId: String,
    val userName: String,
    val name: String,
    val phone: String,
    val email: String,
    val address: String,
    val website: String,
    val businessName: String,
    val businessCatchPhrase: String,
    val businessStrategy: String,
    val locationLat: String?,
    val locationLng: String?,
    val imageUrl: String?,
    val viewLocationCTAText: String,
    val isViewLocationCTAEnabled: Boolean,
    val onViewLocationClick: (
        userId: String,
        companyName: String,
        latitude: String?,
        longitude: String?
    ) -> Unit,
)