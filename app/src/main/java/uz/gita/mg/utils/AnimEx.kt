package uz.gita.mg.utils

import android.widget.ImageView
import uz.gita.mg.R
import uz.gita.mg.data.model.CardData

fun ImageView.openAnim(block: () -> Unit) {
    this.animate().setDuration(250).rotationY(89f).withEndAction {
        this.rotationY = 91f
        val data = this.tag as CardData
        this.setImageResource(data.imgUrl)
        this.animate().setDuration(250).rotationY(180f).withEndAction {
            block.invoke()
        }.start()
    }.start()
}


fun  ImageView.endAnim(block: () -> Unit){
    this.animate().setDuration(250).rotationY(91f).withEndAction{
        this.rotationY=89f
        val data =this.tag as CardData
        this.setImageResource(R.drawable.image_back)
        this.animate().setDuration(250).rotationY(0f).withEndAction{
            block.invoke()
        }.start()
    }.start()
}