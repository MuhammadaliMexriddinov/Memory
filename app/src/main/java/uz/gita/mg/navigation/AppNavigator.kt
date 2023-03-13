package uz.gita.mg.navigation

import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow

interface AppNavigator {
     val navigationFlow:Flow< NavController.()-> Unit >
}