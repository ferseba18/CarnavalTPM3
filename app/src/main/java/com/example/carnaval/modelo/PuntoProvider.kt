package com.example.carnaval.modelo

class PuntoProvider {



    companion object {

        fun cantidadTotalDePuntos(): Int {

            var cantidadTotalDePuntos = 0

            if(listaDePuntos.isNotEmpty()){

                listaDePuntos.forEach {
                    cantidadTotalDePuntos += it.cantidad

                }
            }



            return cantidadTotalDePuntos

        }

        var listaDePuntos: MutableList<PuntoModel> = mutableListOf()





    }
}