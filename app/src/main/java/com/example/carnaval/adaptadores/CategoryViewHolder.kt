package com.example.carnaval.adaptadores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.databinding.CustomInfoWindowBinding
import com.example.carnaval.modelo.StandCategoryModel

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = CustomInfoWindowBinding.bind(view)


    fun render(
        standCategoryModel: StandCategoryModel,
        onClickListener: (StandCategoryModel) -> Unit
    ) {

        binding.title.text = standCategoryModel.name
        binding.snippet.text = standCategoryModel.description
        binding.badge.setImageResource(standCategoryModel.image)

        itemView.setOnClickListener { onClickListener(standCategoryModel) }

    }
}