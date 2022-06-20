package com.example.carnaval.actividades


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadInicialBinding
import com.example.carnaval.modelo.PuntoModel
import com.example.carnaval.modelo.PuntoProvider

class ActividadInicial : AppCompatActivity() {

    val ENTRADA_GOLDEN = "golden"
    val ENTRADA_SILVER = "silver"
    val ENTRADA_BRONZE = "bronze"

    var codigoValidado:Boolean = false

    private lateinit var binding:ActivityActividadInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (codigoValidado){
            verMenuPrincipal()
        }

        binding.Ingresar.setOnClickListener { cargarBeneficiosDeEntrada() }


    }

    private fun cargarBeneficiosDeEntrada() {

        val codigo = binding.Codigo.text.toString().lowercase()

        if (codigo.isEmpty()){
            Toast.makeText(this, "Ingrese el codigo de su entrada", Toast.LENGTH_SHORT).show()
            return
        }

        when(codigo){

            ENTRADA_GOLDEN->{
                PuntoProvider.listaDePuntos.add(PuntoModel(1000,"Beneficios de entrada Golden"))
                codigoValidado=true
                Toast.makeText(this, "Sus beneficios han sido cargado correctamente", Toast.LENGTH_SHORT).show()
                verMenuPrincipal()
            }
            ENTRADA_BRONZE->{
                PuntoProvider.listaDePuntos.add(PuntoModel(500,"Beneficios de entrada Bronze"))
                codigoValidado=true
                Toast.makeText(this, "Sus beneficios han sido cargado correctamente", Toast.LENGTH_SHORT).show()
                verMenuPrincipal()
            }
            ENTRADA_SILVER->{
                PuntoProvider.listaDePuntos.add(PuntoModel(750,"Beneficios de entrada Silver"))
                Toast.makeText(this, "Sus beneficios han sido cargado correctamente", Toast.LENGTH_SHORT).show()
                codigoValidado=true
                verMenuPrincipal()
            }
            else->{
                Toast.makeText(this, "El codigo es incorrecto", Toast.LENGTH_SHORT).show()
                return
            }
        }

    }










    private fun verMenuPrincipal() {
        val intent = Intent(this, MenuPrincipalActivity::class.java)
        intent.putExtra("codigo verificado","correcto")
        startActivity(intent)
    }
    }
