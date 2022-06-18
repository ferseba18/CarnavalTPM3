package com.example.carnaval.actividades

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import androidx.core.content.ContextCompat
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadUbicacionBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener
import android.location.Location

class ActividadUbicacion : AppCompatActivity(), OnMapReadyCallback,
    OnRequestPermissionsResultCallback {

    private lateinit var binding: ActivityActividadUbicacionBinding
    private lateinit var map: GoogleMap

    private val COLOR_GASTRONOMIA = -0x657db
    private val COLOR_STANDS = -0x1
    private val COLOR_EVENTOS = -0x7e387c

    companion object {
        const val LOCATION_REQUEST_CODE = 1
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

        map.setInfoWindowAdapter(CustomInfoWindowAdapter())

        enableMyLocation()
    }

    internal inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter {

        // These are both view groups containing an ImageView with id "badge" and two
        // TextViews with id "title" and "snippet".
        private val window: View = layoutInflater.inflate(R.layout.custom_info_window, null)
        private val contents: View = layoutInflater.inflate(R.layout.custom_info_contents, null)

        override fun getInfoWindow(marker: Marker): View? {

            render(marker, window)
            return window
        }

        override fun getInfoContents(marker: Marker): View? {

            render(marker, contents)
            return contents
        }

        private fun render(marker: Marker, view: View) {
            val badge = when (marker.title!!) {
                "Gastronomia" -> R.drawable.food_
                "Eventos" -> R.drawable.recital_lolla
                "Juegos" -> R.drawable.stand_kermes
                "Carnaval" -> R.drawable.feria_mapa_principal
                else -> 0 // Passing 0 to setImageResource will clear the image view.
            }

            view.findViewById<ImageView>(R.id.badge).setImageResource(badge)

            // Set the title and snippet for the custom info window
            val title: String? = marker.title
            val titleUi = view.findViewById<TextView>(R.id.title)
            val snippet: String? = marker.snippet
            val snippetUi = view.findViewById<TextView>(R.id.snippet)

            snippetUi.text = snippet
            titleUi.text = title


        }
    }


    private fun createMarker() {

        val ubicacionFeria = LatLng(-34.67035170583668, -58.5628052)
        val ubicacionEvento = LatLng(-34.664752334222754, -58.56843709945678)
        val ubicacionStand = LatLng(-34.66865262913868, -58.56489658355712)
        val ubicacionGastronomia = LatLng(-34.667205482314564, -58.562986850738525)

        map.addMarker(
            MarkerOptions().position(ubicacionFeria).title("Carnaval")
                .snippet("Un festival donde encontraras juegos de destreza, juegos mecánicos, puestos de comida y bebida, sorteos y números artísticos")
        )
        map.addMarker(
            MarkerOptions().position(ubicacionGastronomia).title("Gastronomia")
                .snippet("Un espacio gastronómico para vivir un encuentro de diversidad de culturas.")
        )
        map.addMarker(
            MarkerOptions().position(ubicacionEvento).title("Eventos")
                .snippet("Es un lugar donde encontraras musica de todos los estilos; también hay actuaciones cómicas y de danza.")
        )
        map.addMarker(
            MarkerOptions().position(ubicacionStand).title("Juegos")
                .snippet("Un lugar donde podras encontrar divertirte y mostras tus destrezas")
        )

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(ubicacionFeria, 15f),
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
    ) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    //comprueba si el mapa ha sido inicializado, si no es así saldrá de la función gracias a la palabra return,
// si por el contrario map ya ha sido inicializada, es decir que el mapa ya ha cargado,
//  comprobaremos los permisos.

    @SuppressLint("MissingPermission")
    private fun enableMyLocation() {
        if (!::map.isInitialized) return
        if (isPermissionsGranted()) {
            map.isMyLocationEnabled = true
            return
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) || ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ) {
            Toast.makeText(this, "Ve a ajustes y acepta los permisos ", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
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
                return
            } else {
                Toast.makeText(
                    this,
                    "Para activar la localización ve a ajustes y acepta los permisos",
                    Toast.LENGTH_SHORT
                ).show()
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
            else -> {}
        }

    }

    private fun verStand() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }


}