package maderski.asimpleapp.userdirectory.service.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import maderski.asimpleapp.userdirectory.service.UserApi
import maderski.asimpleapp.userdirectory.service.JsonPlaceHolderService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserServiceModule {
    @Provides
    @Singleton
    fun provideUserApi(): UserApi = JsonPlaceHolderService.retrofit.create(UserApi::class.java)
}