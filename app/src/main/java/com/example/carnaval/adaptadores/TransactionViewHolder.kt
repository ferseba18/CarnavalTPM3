package com.example.carnaval.adaptadores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.databinding.ItemPuntosBinding
import com.example.carnaval.modelo.PuntoModel

class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemPuntosBinding.bind(view)


    fun render(puntosModel: PuntoModel) {
        binding.puntosItem.text = puntosModel.cantidad.toString()
        binding.descripcionItem.text = puntosModel.descripcion
        binding.nombreItem.text = puntosModel.name


    }
}