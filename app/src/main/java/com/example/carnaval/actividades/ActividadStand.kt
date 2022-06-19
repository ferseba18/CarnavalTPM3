package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carnaval.adaptadores.AdapatadorStands
import com.example.carnaval.databinding.ActivityActividadStandBinding
import com.example.carnaval.modelo.StandCategoryModel
import com.example.carnaval.modelo.StandModel
import com.example.carnaval.modelo.StandProvider

class ActividadStand : AppCompatActivity() {

    private lateinit var bindingMenu: ActivityActividadStandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMenu = ActivityActividadStandBinding.inflate(layoutInflater)

        setContentView(bindingMenu.root)



        val category = intent.getStringExtra("category").toString()
        bindingMenu.tituloCategory.text = category
        initRecyclerView(category)


    }



    private fun initRecyclerView(category:String){
       val recyclerView = bindingMenu.listadoDeStands
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = AdapatadorStands(StandProvider.listForCategory(category)){
            standModel ->
            onItemSelect(standModel)
        }
    }
    private fun onItemSelect(standModel: StandModel) {
        standDescription(standModel.name)
    }

    private fun standDescription(nameStandModel:String) {
        val location = Intent(this, StandDescriptionActivity::class.java)
        location.putExtra("nameStandModel",nameStandModel)
        startActivity(location)
    }
}
