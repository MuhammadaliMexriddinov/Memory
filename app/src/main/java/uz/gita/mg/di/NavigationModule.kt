package uz.gita.mg.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mg.navigation.AppNavigationManager
import uz.gita.mg.navigation.AppNavigator
import uz.gita.mg.navigation.NavigationHandler
import javax.inject.Singleton

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindsAppNavigation(impl:AppNavigationManager):AppNavigator

    @Binds
    fun appNavigatorHandler(impl:AppNavigationManager):NavigationHandler
}