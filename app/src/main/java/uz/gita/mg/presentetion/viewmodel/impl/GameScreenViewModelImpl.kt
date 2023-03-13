package uz.gita.mg.presentetion.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mg.data.model.CardData
import uz.gita.mg.data.model.LevelEnum
import uz.gita.mg.domain.usecase.GameUseCase
import uz.gita.mg.presentetion.viewmodel.GameScreenViewModel
import javax.inject.Inject

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
@HiltViewModel
class GameScreenViewModelImpl @Inject constructor(
    private val useCase: GameUseCase
) : ViewModel(), GameScreenViewModel {

    override val cardsFlow = MutableStateFlow<List<CardData>>(emptyList())

    override fun getCardsByLevel(levelEnum: LevelEnum) {
        useCase.getCardsByLevel(levelEnum).onEach {
            cardsFlow.emit(it)
        }.launchIn(viewModelScope)
    }

}