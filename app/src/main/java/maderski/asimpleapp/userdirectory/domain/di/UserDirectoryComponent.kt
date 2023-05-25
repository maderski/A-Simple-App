package maderski.asimpleapp.userdirectory.domain.di

import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
@Component(modules = [UserDirectoryDomainModule::class])
class UserDirectoryComponent