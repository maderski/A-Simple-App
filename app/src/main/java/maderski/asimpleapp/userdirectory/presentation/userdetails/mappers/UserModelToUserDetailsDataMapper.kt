package maderski.asimpleapp.userdirectory.presentation.userdetails.mappers

import maderski.asimpleapp.userdirectory.domain.models.AddressModel
import maderski.asimpleapp.userdirectory.domain.models.UserModel
import maderski.asimpleapp.userdirectory.presentation.userdetails.models.UserDetailsData

class UserModelToUserDetailsDataMapper {
    operator fun invoke(
        userModel: UserModel,
        onViewLocationClick: (companyName: String, latitude: String?, longitude: String?) -> Unit
    ) : UserDetailsData =
        UserDetailsData(
            userName = userModel.username,
            name = userModel.name,
            phone = userModel.phone,
            email = userModel.email,
            address = formatAddress(userModel.address),
            website = userModel.website,
            businessName = userModel.company?.name ?: "",
            businessCatchPhrase = userModel.company?.catchPhase ?: "",
            businessStrategy = userModel.company?.businessStrategy ?: "",
            locationLat = userModel.address?.latLng?.lat,
            locationLng = userModel.address?.latLng?.lng,
            imageUrl = null,
            isViewLocationCTAEnabled = userModel.address?.latLng != null,
            viewLocationCTAText = "View On Maps", // TODO: Change to get from a CMS or Resource
            onViewLocationClick = onViewLocationClick
        )

    private fun formatAddress(address: AddressModel?): String {
        val suite = if (address?.suite.isNullOrEmpty()) "" else " ${address?.suite}"
        return "${address?.street}$suite, ${address?.city}, ${address?.zipcode}"
    }
}