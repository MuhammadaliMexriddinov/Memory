package uz.gita.mg.presentetion.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mg.data.model.LevelEnum
import uz.gita.mg.navigation.NavigationHandler
import uz.gita.mg.presentetion.ui.screens.MenuScreenDirections
import uz.gita.mg.presentetion.viewmodel.MenuScreenViewModel
import javax.inject.Inject

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */

@HiltViewModel
class MenuScreenViewModelImpl @Inject constructor(
    private val navigationHandler: NavigationHandler
) :ViewModel(), MenuScreenViewModel{
    override  fun selectLevel(level: LevelEnum) {
          viewModelScope.launch {
              val direction = MenuScreenDirections.actionMenuScreenToGameScreen()
              direction.level = level
              navigationHandler.navigationTo(direction)
          }
    }
}