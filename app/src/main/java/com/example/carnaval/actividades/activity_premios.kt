package com.example.carnaval.actividades

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.carnaval.R

class activity_premios : AppCompatActivity(), SensorEventListener {
 private lateinit var sensorManager: SensorManager
 private var Intentos: Boolean = false
 private lateinit var Circle: TextView
 private var Giro: Boolean = false
 val numeros: MutableList<Int> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premios)
        Circle=findViewById(R.id.Circulo)
    }
    fun addnumeros(){
        numeros.clear()
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);
    }
    fun SetupSensor(){
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also{
            sensorManager.registerListener(this,it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type== Sensor.TYPE_ACCELEROMETER){
            val sides= event.values[0]
            val upDown= event.values[1]
            if(upDown.toInt() == 0 && sides.toInt()== 0){
                Toast.makeText(this, "Debes Mover el Celular para realizar tu intento diario a un premio!", Toast.LENGTH_SHORT).show()
            }
            else{
                Giro=true
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
    fun JugarPremios(){
        if(Giro!=false){
            if(Intentos!=true){
             var tuIntento=numeros.random()
                if(tuIntento==3){
                    Toast.makeText(this, "Felicidades! Has Ganado la Bicicleta!", Toast.LENGTH_SHORT).show()
                }
                else if(tuIntento==7){
                    Toast.makeText(this, "Felicidades! Has Ganado La Mochila!", Toast.LENGTH_SHORT).show()
                }
                else if (tuIntento==10){
                    Toast.makeText(this, "Felicidades! Ganaste el Set Pirata!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "No has ganado nada, pero Segui Participando!", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Ya realizo el intento diario de los premios", Toast.LENGTH_SHORT).show()
            }
        }

    }
}