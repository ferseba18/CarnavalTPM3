package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R

class ActividadStand : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_stand)
    }

    private fun verEventos() {
        val intent = Intent(this, ActividadEvento::class.java)
        startActivity(intent)
    }
    private fun verUbicacion() {
        val intent = Intent(this, ActividadUbicacion::class.java)
        startActivity(intent)
    }
}