package uz.gita.mg.presentetion.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mg.R
import uz.gita.mg.presentetion.viewmodel.SplashScreenViewModel
import uz.gita.mg.presentetion.viewmodel.impl.SplashScreenViewModelImpl

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen :Fragment(R.layout.screen_splash){
   private  val  viewModel:SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel
    }
}