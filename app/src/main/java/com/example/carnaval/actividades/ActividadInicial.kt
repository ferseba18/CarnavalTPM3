package com.example.carnaval.actividades

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Carriers.PASSWORD
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carnaval.R

class ActividadInicial : AppCompatActivity() {
    lateinit var Icodigo : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_inicial)
        Initialize()
    }
 fun Initialize (){
     Icodigo = findViewById(R.id.Codigo)
 }
    fun validateEmpty(): Boolean{
        /* Da error si el campo de codigo de entrada esta vacio*/
        if (Icodigo.text.toString()=="") {
            Icodigo.error = "Debe Ingresar el codigo de entrada"
            return false
        }
        return true;
    }
/* Esta funcion seria para verificar que el codigo de entrada esta en el server
fun ExistCode(): String{
   return Patterns.PASSWORD.matcher(Icodigo).matches();
}*/
fun performSignUp(v: View?) {
    if (validateEmpty()) {

        // data al servidor
        val password: String = Icodigo.getText().toString()
        Toast.makeText(this, "Exito", Toast.LENGTH_SHORT).show()

    }
}
private fun verStands() {
    val intent = Intent(this, ActividadStand::class.java)
    startActivity(intent)
}


}