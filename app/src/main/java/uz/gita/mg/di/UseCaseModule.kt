package uz.gita.mg.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.mg.domain.usecase.GameUseCase
import uz.gita.mg.domain.usecase.GameUseCaseImpl

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGames(impl: GameUseCaseImpl): GameUseCase
}