package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadUbicacionBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ActividadUbicacion : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityActividadUbicacionBinding
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadUbicacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createFragment()

    }

    private fun createFragment(){
        val mapFragment :SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap
        val ubicacionFeria = LatLng(-34.667245, -58.5628052)
        map.addMarker(MarkerOptions().position(ubicacionFeria).title("Feria Carnaval"))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacionFeria,15f),
        2500,
        null
        )

    }



    private fun verStand() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }
}