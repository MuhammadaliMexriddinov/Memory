package uz.gita.mg.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mg.data.model.CardData
import uz.gita.mg.data.model.LevelEnum
import uz.gita.mg.domain.repository.AppRepository
import uz.gita.mg.domain.repository.AppRepositoryImpl
import javax.inject.Inject

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */

class GameUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository
) : GameUseCase {
    override fun getCardsByLevel(level: LevelEnum): Flow<List<CardData>> = flow {
        val mustCount = (level.harCount * level.verCount) / 2
        val list = appRepository.getCardByCount(mustCount)
        val result = ArrayList<CardData>()
        result.addAll(list)
        result.addAll(list)
        result.shuffle()
        emit(result)
    }

}