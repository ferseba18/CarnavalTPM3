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
import com.example.carnaval.modelo.PuntoModel
import com.example.carnaval.modelo.StandProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class ActividadUbicacion : AppCompatActivity(), OnMapReadyCallback,
    OnRequestPermissionsResultCallback {

    private lateinit var binding: ActivityActividadUbicacionBinding
    private lateinit var map: GoogleMap

    private val COLOR_GASTRONOMIA = -0x657db
    private val COLOR_STANDS = -0x1
    private val COLOR_EVENTOS = -0x7e387c
    private var ubicacionPorDefecto = LatLng(-34.67035170583668, -58.5628052)
    private  var standName : String = ""
    private var listaDeMarker: MutableList<Marker> = mutableListOf()




    companion object {
        const val LOCATION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadUbicacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        standName = intent.getStringExtra("name").toString()






        createFragment()

    }

    override fun onStart() {
        super.onStart()
        if(standName != ""){
            cambiarUbicacionPorDefecto(standName)



        }

    }




    private fun cambiarUbicacionPorDefecto(nameStand : String){

        val name = nameStand
        val standModel = StandProvider.getStandForName(name)
        val lat = standModel.locationLat
        val lng = standModel.locationLng

        ubicacionPorDefecto = LatLng(lat, lng)

    }
    private fun markerInfoWindowShow(nameStand : String){

        val name = nameStand
        val standModel = StandProvider.getStandForName(name)

        val nameSra = standModel.name



        for(marker in listaDeMarker){
            if (marker.title == nameSra){
                marker?.showInfoWindow()
                Toast.makeText(this,marker.title, Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {


        map = googleMap

        map.setInfoWindowAdapter(CustomInfoWindowAdapter())

        map.setOnInfoWindowClickListener { marker ->
            val nameStandModel = marker.title.toString()

            standDescription(nameStandModel)
        }

        createPolylineGastronomia()
        createPolylineEventos()
        createPolylineStands()
        addMarkerList()

        animateCameraMarker()

        markerInfoWindowShow(standName)

        /*for (marker in  listaDeMarker){

            if(marker.title == standName)

                Toast.makeText(this, marker.title, Toast.LENGTH_SHORT).show()

        }*/






        enableMyLocation()
    }

    internal inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter {

        private val window: View = layoutInflater.inflate(R.layout.custom_info_window, null)
        private val contents: View = layoutInflater.inflate(R.layout.custom_info_window, null)

        override fun getInfoWindow(marker: Marker): View? {

            render(marker, window)
            return window
        }

        override fun getInfoContents(marker: Marker): View? {

            render(marker, contents)
            return contents
        }

        private fun render(marker: Marker, view: View) {

            val title: String? = marker.title
            var titleUi = view.findViewById<TextView>(R.id.title)
            titleUi.text = title
            var descriptionUI = view.findViewById<TextView>(R.id.snippet)



            for (stand in StandProvider.listadoDeStands) {

                if (stand.name == title) {
                    descriptionUI.text = stand.description
                    view.findViewById<ImageView>(R.id.badge).setImageResource(stand.image)
                }

            }


        }
    }


    private fun animateCameraMarker() {


       map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(ubicacionPorDefecto, 17f),
            2500,
            null
        )

    }

    private fun addMarkerList() {

        for (stand in StandProvider.listadoDeStands) {


                val ubicacion = LatLng(stand.locationLat, stand.locationLng)
                val title = stand.name
                val description = stand.description


            var marker = map.addMarker(
                MarkerOptions().position(ubicacion).title(title).snippet(description)
            )

            if (marker != null) {
                listaDeMarker.add(marker)
            }






        }



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

    private fun standDescription(nameStandModel: String) {
        val location = Intent(this, StandDescriptionActivity::class.java)
        location.putExtra("nameStandModel", nameStandModel)
        startActivity(location)
    }


}