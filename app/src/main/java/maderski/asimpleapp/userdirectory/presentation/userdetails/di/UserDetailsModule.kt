package maderski.asimpleapp.userdirectory.presentation.userdetails.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import maderski.asimpleapp.userdirectory.presentation.userdetails.mappers.UserModelToUserDetailsDataMapper

@Module
@InstallIn(ViewModelComponent::class)
class UserDetailsModule {
    @Provides
    fun provideUserModelToUserDetailsDataMapper() = UserModelToUserDetailsDataMapper()
}