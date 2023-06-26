package maderski.asimpleapp.userdirectory.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import maderski.asimpleapp.userdirectory.data.mappers.AddressToAddressModelMapper
import maderski.asimpleapp.userdirectory.data.mappers.CompanyToCompanyModelMapper
import maderski.asimpleapp.userdirectory.data.mappers.GeoToLatLngModelMapper
import maderski.asimpleapp.userdirectory.data.mappers.UserToUserModelMapper
import maderski.asimpleapp.userdirectory.data.repository.UserRepository
import maderski.asimpleapp.userdirectory.data.repository.UserRepositoryImpl
import maderski.asimpleapp.userdirectory.service.UserApi

@Module
@InstallIn(ViewModelComponent::class)
class UserDirectoryDomainModule {
    @Provides
    fun provideCompanyModelMapper() = CompanyToCompanyModelMapper()

    @Provides
    fun provideLatLngModelMapper() = GeoToLatLngModelMapper()

    @Provides
    fun provideAddressModelMapper(
        latLngModelMapper: GeoToLatLngModelMapper,
    ) = AddressToAddressModelMapper(latLngModelMapper)

    @Provides
    fun provideUserModelMapper(
        companyModelMapper: CompanyToCompanyModelMapper,
        addressModelMapper: AddressToAddressModelMapper,
    ) = UserToUserModelMapper(companyModelMapper, addressModelMapper)

    @Provides
    fun provideUserRepository(
        userApi: UserApi,
        userModelMapper: UserToUserModelMapper,
    ): UserRepository = UserRepositoryImpl(userApi, userModelMapper)
}