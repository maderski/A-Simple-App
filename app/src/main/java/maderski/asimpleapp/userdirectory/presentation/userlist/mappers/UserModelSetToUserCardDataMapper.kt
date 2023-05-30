package maderski.asimpleapp.userdirectory.presentation.userlist.mappers

import maderski.asimpleapp.userdirectory.domain.models.UserModel
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData

class UserModelSetToUserCardDataMapper {
    operator fun invoke(
        userModels: Set<UserModel>,
        onUserSelected: (id: Int) -> Unit
    ): List<UserCardData> =
        userModels.map { userModel ->
            UserCardData(
                userModel.id,
                userModel.name,
                userModel.company?.name ?: "",
                null, // Service does not provide an image.
                onUserSelected
            )
        }
}