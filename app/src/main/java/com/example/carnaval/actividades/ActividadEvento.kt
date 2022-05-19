package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R

class ActividadEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_evento)
    }
    private fun verStands() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }
    private fun verUbicacion() {
        val intent = Intent(this, ActividadUbicacion::class.java)
        startActivity(intent)
    }
    private fun verPerfil() {
        val intent = Intent(this, ActividadPerfil::class.java)
        startActivity(intent)
    }
}