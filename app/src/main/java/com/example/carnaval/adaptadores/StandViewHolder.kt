package com.example.carnaval.adaptadores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.databinding.ItemStandsBinding
import com.example.carnaval.modelo.StandModel

//implementar el viewHolder

class StandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    
    val binding = ItemStandsBinding.bind(view)

    fun render(standModel : StandModel){

        binding.imageStand.setImageResource(standModel.image)
        binding.title.text = standModel.name
    }
}