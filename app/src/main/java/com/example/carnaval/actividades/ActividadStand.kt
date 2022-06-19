package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carnaval.adaptadores.AdapatadorStands
import com.example.carnaval.databinding.ActivityActividadStandBinding
import com.example.carnaval.modelo.StandProvider

class ActividadStand : AppCompatActivity() {

    private lateinit var bindingMenu: ActivityActividadStandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMenu = ActivityActividadStandBinding.inflate(layoutInflater)

        setContentView(bindingMenu.root)

        val category = intent.getStringExtra("category").toString()

        initRecyclerView(category)


    }

    private fun initRecyclerView(category:String){
       val recyclerView = bindingMenu.listadoDeStands
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = AdapatadorStands(StandProvider.listForCategory(category))
    }

}
