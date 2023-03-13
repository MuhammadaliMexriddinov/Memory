package uz.gita.mg.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.gita.mg.R
import uz.gita.mg.data.model.CardData
import javax.inject.Inject
import javax.inject.Singleton

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */

@Singleton
class AppRepositoryImpl  @Inject constructor() : AppRepository {
    private val cardList = ArrayList<CardData>()

    init {
        cardList.add(CardData(R.drawable.image_1, 1))
        cardList.add(CardData(R.drawable.image_2, 2))
        cardList.add(CardData(R.drawable.image_3, 3))
        cardList.add(CardData(R.drawable.image_4, 4))
        cardList.add(CardData(R.drawable.image_5, 5))
        cardList.add(CardData(R.drawable.image_6, 6))
        cardList.add(CardData(R.drawable.image_7, 7))
        cardList.add(CardData(R.drawable.image_8, 8))
        cardList.add(CardData(R.drawable.image_9, 9))
        cardList.add(CardData(R.drawable.image_10, 10))
        cardList.add(CardData(R.drawable.image_11, 11))
        cardList.add(CardData(R.drawable.image_12, 12))
        cardList.add(CardData(R.drawable.image_13, 13))
        cardList.add(CardData(R.drawable.image_14, 14))
        cardList.add(CardData(R.drawable.image_15, 15))
        cardList.add(CardData(R.drawable.image_16, 16))
        cardList.add(CardData(R.drawable.image_17, 17))
        cardList.add(CardData(R.drawable.image_18, 18))
        cardList.add(CardData(R.drawable.image_19, 19))
        cardList.add(CardData(R.drawable.image_20, 20))
        cardList.add(CardData(R.drawable.image_21, 21))
        cardList.add(CardData(R.drawable.image_22, 22))
        cardList.add(CardData(R.drawable.image_23, 23))
        cardList.add(CardData(R.drawable.image_24, 24))
        cardList.add(CardData(R.drawable.image_25, 25))
    }

    override suspend fun getCardByCount(count: Int): List<CardData> = withContext(Dispatchers.IO) {
        cardList.shuffle()
        return@withContext cardList.subList(0,count)
    }
}