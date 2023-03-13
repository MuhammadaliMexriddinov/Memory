package uz.gita.mg.presentetion.ui.screens

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mg.R
import uz.gita.mg.data.model.LevelEnum
import uz.gita.mg.databinding.ScreenMenuBinding
import uz.gita.mg.presentetion.viewmodel.MenuScreenViewModel
import uz.gita.mg.presentetion.viewmodel.impl.MenuScreenViewModelImpl

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */

@AndroidEntryPoint
class MenuScreen :Fragment(R.layout.screen_menu){

    private  val viewModel:MenuScreenViewModel by viewModels<MenuScreenViewModelImpl>()
    private  val  binding by viewBinding(ScreenMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.easy.setOnClickListener { viewModel.selectLevel(LevelEnum.EASY) }
        binding.medium.setOnClickListener { viewModel.selectLevel(LevelEnum.MEDIUM) }
        binding.hard.setOnClickListener { viewModel.selectLevel(LevelEnum.HARD) }

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }


    }
}