package maderski.asimpleapp.userdirectory.service

import maderski.asimpleapp.userdirectory.service.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/Users")
    suspend fun fetchUsers(): Response<List<User>>

    @GET("/Users/{id}")
    suspend fun fetchUser(
        @Path("id") id: Int
    ): Response<User>
}