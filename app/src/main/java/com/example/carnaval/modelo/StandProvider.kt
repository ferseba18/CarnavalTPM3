package com.example.carnaval.modelo

class StandProvider {

    var listadoPorCategoria: MutableList<StandModel> = mutableListOf()


    fun listForCategory(category : String): MutableList<StandModel> {

        val category = category

        for(stand in listadoDeStands){
            if (stand.category == category){
                listadoPorCategoria.add(stand)
            }
        }

        return listadoPorCategoria

    }

    companion object{

        val listadoDeStands = listOf<StandModel>(

        )
    }
}