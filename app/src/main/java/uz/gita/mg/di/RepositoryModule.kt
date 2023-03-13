package uz.gita.mg.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mg.domain.repository.AppRepository
import uz.gita.mg.domain.repository.AppRepositoryImpl

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsAppRepository(impl:AppRepositoryImpl):AppRepository
}