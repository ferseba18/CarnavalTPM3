package com.example.carnaval.actividades

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Carriers.PASSWORD
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.example.carnaval.R

class ActividadInicial : AppCompatActivity() {
    lateinit var Icodigo: EditText
    lateinit var Codigos: Array<String>
    lateinit var S: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_inicial)
        Initialize()
    }

    fun Initialize() {
        Icodigo = findViewById(R.id.Codigo)
    }

    fun validateEmpty(): Boolean {
        /* Da error si el campo de codigo de entrada esta vacio*/
        if (Icodigo.text.toString() == "") {
            Icodigo.error = "Debe Ingresar el codigo de entrada"
            return false
        }
        return true;
    }

    fun ExistCode(): String {

        S = "Codigo de entrada no valido"
        for (n in Codigos) {
            if (n == Icodigo.toString())
                Toast.makeText(this, "Exito", Toast.LENGTH_SHORT).show()
            else {
                Icodigo.error = "El codigo no es valido"
                return S
            }
        }

        return Icodigo.toString()
    }

    private fun verStands() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }

    
}
