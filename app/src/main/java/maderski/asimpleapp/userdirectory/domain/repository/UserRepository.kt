package maderski.asimpleapp.userdirectory.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import maderski.asimpleapp.userdirectory.domain.mappers.UserToUserModelMapper
import maderski.asimpleapp.userdirectory.domain.models.UserModel
import maderski.asimpleapp.userdirectory.service.UserService
import javax.inject.Inject

interface UserRepository {
    suspend fun getAllUsers(): Result<Set<UserModel>>
    suspend fun getUser(id: Int): Result<UserModel>
}

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userModelMapper: UserToUserModelMapper
) : UserRepository {
    override suspend fun getAllUsers(): Result<Set<UserModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = userService.fetchUsers()
                val userList = response.body()
                if (response.isSuccessful && userList != null) {
                    val userModelSet = userList.mapNotNull { user ->
                        userModelMapper(user)
                    }.toSet()
                    Result.success(userModelSet)
                } else {
                    throw Exception(response.message())
                }
            } catch (ex: Exception) {
                Result.failure(ex)
            }
        }
    }

    override suspend fun getUser(id: Int): Result<UserModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = userService.fetchUser(id)
                val user = userModelMapper(response.body())
                if (response.isSuccessful && user != null) {
                    Result.success(user)
                } else {
                    throw Exception(response.message())
                }
            } catch (ex: Exception) {
                Result.failure(ex)
            }
        }
    }
}