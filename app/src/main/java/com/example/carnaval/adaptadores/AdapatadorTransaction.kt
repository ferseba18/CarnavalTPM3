package com.example.carnaval.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.R
import com.example.carnaval.modelo.PuntoModel

class AdapatadorTransaction(val listaDePuntos:List<PuntoModel>) : RecyclerView.Adapter<TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
     val layoutInflate = LayoutInflater.from(parent.context)
        return TransactionViewHolder(layoutInflate.inflate(R.layout.item_puntos, parent, false))
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = listaDePuntos[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listaDePuntos.size
}