package com.example.carnaval.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.R
import com.example.carnaval.modelo.StandCategoryModel

class AdapterCategory(val categorias : List<StandCategoryModel>) :RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflate = LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflate.inflate(R.layout.custom_info_window,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categorias[position]
        holder.render(category)
    }

    override fun getItemCount(): Int {
        return categorias.size
    }
}