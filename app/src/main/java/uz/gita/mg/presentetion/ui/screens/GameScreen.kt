package uz.gita.mg.presentetion.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mg.R
import uz.gita.mg.data.model.CardData
import uz.gita.mg.data.model.LevelEnum
import uz.gita.mg.databinding.ScreenGameBinding
import uz.gita.mg.presentetion.viewmodel.GameScreenViewModel
import uz.gita.mg.presentetion.viewmodel.impl.GameScreenViewModelImpl
import uz.gita.mg.utils.endAnim
import uz.gita.mg.utils.openAnim

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {

    private val viewModel: GameScreenViewModel by viewModels<GameScreenViewModelImpl>()
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val navArg by navArgs<GameScreenArgs>()
    private var level = LevelEnum.EASY
    private var _height = 0
    private var _width = 0
    private var isEnabled = true
    private var count = 0
    private var firstData: CardData? = null
    private var firstImage: ImageView? = null
    private var secondImage: ImageView? = null
    private var secondData: CardData? = null
    private val images = ArrayList<ImageView>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        level = navArg.level
        binding.main.post {
            _height = binding.space.height / level.verCount
            _width = binding.space.width / level.harCount
            viewModel.getCardsByLevel(level)
        }
        viewModel.cardsFlow.onEach { describeImages(it) }.launchIn(lifecycleScope)
    }

    private fun describeImages(list: List<CardData>) {
        if (list.isEmpty()) return
        for (i in 0 until level.verCount) {
            for (j in 0 until level.harCount) {
                val imageView = ImageView(requireContext())
                imageView.tag = list[i * level.harCount + j]
                binding.container.addView(imageView)
                val lp = imageView.layoutParams as ConstraintLayout.LayoutParams
                lp.apply {
                    this.height = _height
                    this.width = _width
                }
                lp.setMargins(4, 4, 4, 4)
                imageView.layoutParams = lp
                imageView.x = (j * _width).toFloat()
                imageView.y = (i * _height).toFloat()
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                imageView.setImageResource(R.drawable.image_back)
                images.add(imageView)

                val data = list[i * level.harCount + j]
            }
        }
        addClickListener()
    }

    private fun addClickListener() {

        images.forEach { view ->
            view.setOnClickListener {
                if (!isEnabled || view.rotationY == 180f) return@setOnClickListener
                isEnabled = false
                if (count == 0) {
                    firstData = view.tag as CardData
                    firstImage = view
                    count++
                } else if (count == 1) {
                    secondData = view.tag as CardData
                    secondImage = view
                    count++
                    isEnabled = false
                }
                view.openAnim {
                    if (count == 2) {
                        if (firstData?.amount == secondData?.amount) {
                            firstImage?.visibility = View.INVISIBLE
                            firstImage?.isEnabled = false
                            secondImage?.visibility = View.INVISIBLE
                            secondImage?.isEnabled = false
                            count += 2
                            if (count == images.size) {
                                Toast.makeText(requireContext(), "You Win", Toast.LENGTH_LONG).show()

                            }
                        } else {
                            firstImage?.endAnim {}
                            secondImage?.endAnim {}

                        }
                        firstImage = null; secondImage = null; firstData = null; secondData = null
                        count = 0
                    }
                    isEnabled = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        images.clear()
    }
}