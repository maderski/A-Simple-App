package maderski.asimpleapp.userdirectory.presentation.userlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import maderski.asimpleapp.userdirectory.presentation.userlist.mappers.UserModelSetToUserCardDataMapper

@Module
@InstallIn(ViewModelComponent::class)
class UserListModule {
    @Provides
    fun provideUserModelSetToUserCardDataMapper() = UserModelSetToUserCardDataMapper()
}