package maderski.asimpleapp.userdirectory.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JsonPlaceHolderService {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}