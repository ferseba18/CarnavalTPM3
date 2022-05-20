package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadInicialBinding

class ActividadInicial : AppCompatActivity() {

    private lateinit var binding: ActivityActividadInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityActividadInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMap.setOnClickListener { verUbicacion() }



    }

    private fun verStands() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }
    private fun verUbicacion() {
        val intent = Intent(this, ActividadUbicacion::class.java)
        startActivity(intent)
    }
}