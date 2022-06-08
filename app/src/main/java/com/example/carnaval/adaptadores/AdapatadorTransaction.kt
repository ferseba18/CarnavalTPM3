package com.example.carnaval.adaptadores

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.modelo.PuntoModel

class AdapatadorTransaction(val listaDePuntos:List<PuntoModel>) : RecyclerView.Adapter<TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listaDePuntos.size
    }
}