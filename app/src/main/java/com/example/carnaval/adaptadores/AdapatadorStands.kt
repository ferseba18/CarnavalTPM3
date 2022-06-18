package com.example.carnaval.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.R
import com.example.carnaval.modelo.StandModel

//Implementar RecyclerView
class AdapatadorStands (val listadoDeStands : List<StandModel>) : RecyclerView.Adapter<StandViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandViewHolder {
        val layoutInflate = LayoutInflater.from(parent.context)
        return StandViewHolder(layoutInflate.inflate(R.layout.item_stands,parent,false))
    }

    override fun onBindViewHolder(holder: StandViewHolder, position: Int) {
        val item = listadoDeStands[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return listadoDeStands.size
    }

}