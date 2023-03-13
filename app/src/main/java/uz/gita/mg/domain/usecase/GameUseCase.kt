package uz.gita.mg.domain.usecase

import uz.gita.mg.data.model.CardData
import uz.gita.mg.data.model.LevelEnum
import java.util.concurrent.Flow

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
interface GameUseCase {
    fun getCardsByLevel(level: LevelEnum): kotlinx.coroutines.flow.Flow<List<CardData>>
}