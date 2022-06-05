package com.example.carnaval.actividades

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadUbicacionBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class ActividadUbicacion : AppCompatActivity(), OnMapReadyCallback
     {

    private lateinit var binding: ActivityActividadUbicacionBinding
    private lateinit var map: GoogleMap

    private val COLOR_GASTRONOMIA = -0x657db
    private val COLOR_STANDS = -0x1
    private val COLOR_EVENTOS = -0x7e387c

    companion object {
        const val LOCATION_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadUbicacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createFragment()

    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap

        createPolylineGastronomia()
        createPolylineEventos()
        createPolylineStands()
        createMarker()



        enableMyLocation()
    }

    private fun createMarker() {

        val ubicacionFeria = LatLng(-34.67035170583668, -58.5628052)
        val ubicacionEvento = LatLng(-34.664752334222754, -58.56843709945678)
        val ubicacionStand = LatLng(-34.66865262913868, -58.56489658355712)
        val ubicacionGastronomia = LatLng(-34.667205482314564, -58.562986850738525)

        map.addMarker(MarkerOptions().position(ubicacionFeria).title("Feria Carnaval"))?.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.concierto))
        map.addMarker(MarkerOptions().position(ubicacionGastronomia).title("Patio De Comidas"))
        map.addMarker(MarkerOptions().position(ubicacionEvento).title("Eventos"))
        map.addMarker(MarkerOptions().position(ubicacionStand).title("Stands"))

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(ubicacionFeria, 13f),
            2500,
            null
        )
    }

    private fun createPolylineGastronomia() {


        val polylineAreaGastronomia = map.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(-34.6677172810318, -58.5682225227356),
                    LatLng(-34.666075984302125, -58.56620550155639),
                    LatLng(-34.66964091000384, -58.56133460998535),
                    LatLng(-34.67135272574701, -58.56339454650879),
                    LatLng(-34.6677172810318, -58.5682225227356)
                )
        )

        polylineAreaGastronomia.fillColor = COLOR_GASTRONOMIA
        polylineAreaGastronomia.strokeColor = COLOR_GASTRONOMIA

    }

    private fun createPolylineEventos() {


        val polylineAreaEventos = map.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(-34.664752334222754, -58.56451034545898),
                    LatLng(-34.6677172810318, -58.5682225227356),
                    LatLng(-34.664875875791566, -58.57210636138915),
                    LatLng(-34.6615754877555, -58.56843709945678),
                    LatLng(-34.664752334222754, -58.56451034545898)
                )
        )

        polylineAreaEventos.fillColor = COLOR_EVENTOS
        polylineAreaEventos.strokeColor = COLOR_EVENTOS

    }

    private fun createPolylineStands() {


        val polylineStands = map.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(-34.66609363282699, -58.56618404388427),
                    LatLng(-34.669658557769274, -58.56131315231324),
                    LatLng(-34.66831731688074, -58.55989694595336),
                    LatLng(-34.664805280631946, -58.564553260803216),
                    LatLng(-34.66609363282699, -58.56618404388427)
                )
        )
        polylineStands.fillColor = COLOR_STANDS
        polylineStands.strokeColor = COLOR_STANDS


    }


// para comprobar si el permiso ha sido aceptado o no.

    private fun isPermissionsGranted() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    //comprueba si el mapa ha sido inicializado, si no es así saldrá de la función gracias a la palabra return,
// si por el contrario map ya ha sido inicializada, es decir que el mapa ya ha cargado,
//  comprobaremos los permisos.

    @SuppressLint("MissingPermission")
    private fun enableMyLocation() {
        if (!::map.isInitialized) return
        if (isPermissionsGranted()) {
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(this, "Ve a ajustes y acepta los permisos ", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_REQUEST_CODE -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                enableMyLocation()

            } else {
                Toast.makeText(
                    this,
                    "Para activar la localización ve a ajustes y acepta los permisos",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {}
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun verStand() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }


}