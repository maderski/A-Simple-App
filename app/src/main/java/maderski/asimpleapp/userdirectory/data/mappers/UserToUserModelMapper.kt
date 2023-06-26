package maderski.asimpleapp.userdirectory.data.mappers

import maderski.asimpleapp.userdirectory.data.models.UserModel
import maderski.asimpleapp.userdirectory.service.models.User
import javax.inject.Inject

class UserToUserModelMapper @Inject constructor(
    private val companyModelMapper: CompanyToCompanyModelMapper,
    private val addressModelMapper: AddressToAddressModelMapper,
) {
    operator fun invoke(user: User?): UserModel? =
        user?.let {
            UserModel(
                id = it.id ?: throw IllegalArgumentException("ID cannot be null!"),
                name = it.name ?: throw IllegalArgumentException("Name cannot be null"),
                username = it.username ?: throw IllegalArgumentException("Username cannot be null!"),
                email = it.email ?: throw IllegalArgumentException("Email cannot be null"),
                address = addressModelMapper(it.address),
                phone = it.phone ?: "Unknown",
                website = it.website ?: "Unknown",
                company = companyModelMapper(it.company),
            )
        }
}