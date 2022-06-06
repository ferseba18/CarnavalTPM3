package com.example.carnaval.actividades

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadUbicacionBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.properties.Delegates

class ActividadUbicacion : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityActividadUbicacionBinding
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient : FusedLocationProviderClient
    private var ver by Delegates.notNull<Int>()
    private var status: Boolean = false

    companion object
    {
           private const val LOCATION_PERMISSION_REQUEST_CODE=1
       }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadUbicacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
       fusedLocationClient= LocationServices.getFusedLocationProviderClient(this)
        createFragment()

    }

    private fun createFragment(){
        val mapFragment :SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        status
        ver= ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
        if(ver != PackageManager.PERMISSION_GRANTED) {
       status= true
        }
        return

    }
      fun UbicacionDeFeria(googleMap:GoogleMap){
          if(status!=false){
          map = googleMap
          val ubicacionFeria = LatLng(-34.667245, -58.5628052)
          map.addMarker(MarkerOptions().position(ubicacionFeria).title("Feria Carnaval"))
          map.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacionFeria,15f),
              2500,
              null)
          }
      }


    private fun verStand() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }

}
