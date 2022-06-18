package com.example.carnaval.adaptadores

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.R
import com.example.carnaval.modelo.StandCategoryModel

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

   val nombre = view.findViewById<TextView>(R.id.title)
    val description = view.findViewById<TextView>(R.id.snippet)
    val image = view.findViewById<ImageView>(R.id.badge)

    fun render(standCategoryModel : StandCategoryModel){

        nombre.text = standCategoryModel.name
        description.text = standCategoryModel.description
        image.setImageResource(standCategoryModel.image)

    }
}