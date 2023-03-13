package uz.gita.mg.navigation

import androidx.navigation.NavDirections

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
interface NavigationHandler {
    suspend fun  back()
    suspend fun navigationTo(direction: NavDirections)
}

