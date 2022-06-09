package com.example.carnaval.adaptadores

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.R
import com.example.carnaval.modelo.PuntoModel

class TransactionViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val puntos = view.findViewById<TextView>(R.id.puntos_item)
    val descripcion = view.findViewById<TextView>(R.id.descripcion_item)


    fun render(puntosModel : PuntoModel)
    {
        puntos.text= puntosModel.cantidad.toString()
        descripcion.text = puntosModel.descripcion


    }
}