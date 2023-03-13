package uz.gita.mg.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
@Singleton
class AppNavigationManager @Inject constructor() : AppNavigator, NavigationHandler {

    private suspend fun navigate(block: NavController.() -> Unit) { navigationFlow.emit(block) }
    override val navigationFlow = MutableSharedFlow<NavController.() -> Unit>()
    override suspend fun back() = navigate { popBackStack() }
    override suspend fun navigationTo(direction: NavDirections) = navigate { navigate(direction) }
}