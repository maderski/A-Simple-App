package maderski.asimpleapp.userdirectory.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import maderski.asimpleapp.userdirectory.data.mappers.UserToUserModelMapper
import maderski.asimpleapp.userdirectory.data.models.UserModel
import maderski.asimpleapp.userdirectory.service.UserApi
import javax.inject.Inject

interface UserRepository {
    suspend fun getAllUsers(): Result<Set<UserModel>>
    suspend fun getUser(id: Int): Result<UserModel>
}

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val userModelMapper: UserToUserModelMapper
) : UserRepository {
    override suspend fun getAllUsers(): Result<Set<UserModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = userApi.fetchUsers()
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
                val response = userApi.fetchUser(id)
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