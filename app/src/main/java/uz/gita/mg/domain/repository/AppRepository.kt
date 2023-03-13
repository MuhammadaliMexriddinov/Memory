package uz.gita.mg.domain.repository

import uz.gita.mg.data.model.CardData

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
interface AppRepository {
    suspend fun getCardByCount(count:Int):List<CardData>
}