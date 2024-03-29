package com.lennyrbriones.horoscopeapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.lennyrbriones.horoscopeapp.databinding.ItemHoroscopeBinding
import com.lennyrbriones.horoscopeapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    //using lambda
    fun render(horoscopeInfo: HoroscopeInfo, onItemselected: (HoroscopeInfo) -> Unit){
        val context = binding.tvtitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvtitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            //calling the second lambda to summon up the first lambda with the data
        startRotationAnimation(binding.ivHoroscope, secondLambda = {onItemselected(horoscopeInfo)})
        //onItemselected(horoscopeInfo)
        }
    }

    //generating the animation
    private fun startRotationAnimation(view: View, secondLambda:() -> Unit){ //second lambda
        view.animate().apply {
            duration = 500 // in milliseconds
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ secondLambda() } //setting at the end of action
            start()
        }
    }
}