package uz.gita.mg.presentetion.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.mg.domain.usecase.GameUseCase
import uz.gita.mg.navigation.NavigationHandler
import uz.gita.mg.presentetion.ui.screens.SplashScreenDirections
import uz.gita.mg.presentetion.viewmodel.SplashScreenViewModel
import javax.inject.Inject

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
@HiltViewModel
class SplashScreenViewModelImpl @Inject constructor(
    private val navigationHandler: NavigationHandler
) :
    SplashScreenViewModel, ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            navigationHandler.navigationTo(SplashScreenDirections.actionSplashScreenToMenuScreen())
        }

    }
}
