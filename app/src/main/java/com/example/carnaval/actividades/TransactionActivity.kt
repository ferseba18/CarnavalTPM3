package com.example.carnaval.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carnaval.R
import com.example.carnaval.adaptadores.AdapatadorTransaction
import com.example.carnaval.databinding.ActivityTransactionBinding
import com.example.carnaval.modelo.PuntoModel
import com.example.carnaval.modelo.PuntoProvider

class TransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView(){

        var puntosTotal = binding.totalPuntos
        puntosTotal.text = cantidadTotalDePuntos(PuntoProvider.listaDePuntos)
        val manager = LinearLayoutManager(this)
        val recyclerView = binding.listadoDePuntos
        recyclerView.layoutManager = manager
        recyclerView.adapter = AdapatadorTransaction(PuntoProvider.listaDePuntos)

    }

    private fun cantidadTotalDePuntos(listaDePuntos:List<PuntoModel>):String{

        var cantidadTotalDePuntos = 0

        listaDePuntos.forEach {
            cantidadTotalDePuntos+= it.cantidad
        }

        return cantidadTotalDePuntos.toString()

    }
}