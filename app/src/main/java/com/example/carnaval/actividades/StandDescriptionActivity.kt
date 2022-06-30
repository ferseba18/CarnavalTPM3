package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityStandDescriptionBinding
import com.example.carnaval.modelo.StandModel
import com.example.carnaval.modelo.StandProvider

class StandDescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStandDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameStandModel = intent.getStringExtra("nameStandModel").toString()

        renderStand(nameStandModel)

        binding.btnUbicacion.setOnClickListener { location() }
    }

    fun renderStand(nameStandModel:String){

        val standModel = StandProvider.getStandForName(nameStandModel)

        binding.nameStandDescription.text = standModel.name
        binding.descriptionStandDescription.text = standModel.description
        binding.priceStandDescription.text = standModel.price.toString()
        binding.imageStandDescription.setImageResource(standModel.image)


    }
    private fun location() {
        val name = binding.nameStandDescription.toString()
        val location = Intent(this, ActividadUbicacion::class.java)
        location.putExtra("name",name)
        startActivity(location)
    }
}