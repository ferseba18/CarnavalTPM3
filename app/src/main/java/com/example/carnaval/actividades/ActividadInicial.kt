package com.example.carnaval.actividades


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.carnaval.R

class ActividadInicial : AppCompatActivity() {

    lateinit var Icodigo: EditText
    lateinit var NumeroEntrada: String
    lateinit var CodigosV: Array<String>
    lateinit var Codigos: Array<String>
    protected var VIP: Boolean = false
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
        for (n in CodigosV) {
            if (n== Icodigo.toString()){
                Toast.makeText(this, "Exito. Bienvenido a la seccion VIP", Toast.LENGTH_SHORT).show()
                VIP= true
            }
            else {
                for (n in Codigos){
                    if(n== Icodigo.toString()){
                        Toast.makeText(this, "Exito. Bienvenido a la seccion VIP", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Icodigo.error = "El codigo no es valido"
                        return S
                    }
                }
            }
        }

        return Icodigo.toString()

        }
    private fun verStands() {
        val intent = Intent(this, ActividadStand::class.java)
        startActivity(intent)
    }
    }
