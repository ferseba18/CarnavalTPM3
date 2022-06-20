package com.example.carnaval.modelo

data class StandModel(
    val name:String,
    val description:String,
    val image:Int,
    val price:Int,
    val category:String,
    val locationLat :Double,
    val locationLng :Double
)
