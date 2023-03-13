package uz.gita.mg.presentetion.viewmodel

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mg.data.model.CardData
import uz.gita.mg.data.model.LevelEnum

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
interface GameScreenViewModel {
    val cardsFlow: StateFlow<List<CardData>>
    fun getCardsByLevel(levelEnum: LevelEnum)
}