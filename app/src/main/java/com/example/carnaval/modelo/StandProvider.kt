package com.example.carnaval.modelo

import com.example.carnaval.R

class StandProvider {





    companion object {

        var listadoPorCategoria: MutableList<StandModel> = mutableListOf()
        lateinit var standForName:StandModel

        fun getStandForName(nameStand:String):StandModel{
            val nameStand = nameStand

            

            for (stand in listadoDeStands) {

                if (stand.name == nameStand) {
                    standForName = stand
                }
            }

            return standForName

        }

        fun listForCategory(category: String): MutableList<StandModel> {

            val category = category

            if(listadoPorCategoria.isNotEmpty()){
                listadoPorCategoria.clear()
            }

            for (stand in listadoDeStands) {

                if (stand.category == category) {
                    listadoPorCategoria.add(stand)
                }
            }

            return listadoPorCategoria

        }




        val listadoDeStands = listOf<StandModel>(

            StandModel(
                "No Te Va Gustar",
                "La banda Uruuaya presentara su ultimo album Luz, con grandes artistas invitados",
                R.drawable.evento_ntvg,
                500,
                "Eventos"
            ),
            StandModel(
                "Gabriel Rolon",
                "'Palabra plena', en cambio, nos desafía a pensar, a transitar el laberinto de nuestro propio enigma intentando evitar las trampas de la comodidad. Porque las cosas importantes de la vida son incómodas. Caminamos entre el amor y la pérdida, la felicidad y la angustia, la esperanza y el deseo.",
                R.drawable.evento_rolon,
                500,
                "Eventos"
            ),
            StandModel(
                "Tacos",
                "El taco es una preparación culinaria muy popular de México que consiste en una tortilla, generalmente de maíz, que se dobla o se enrolla para contener dentro diversos ingredientes y algún tipo de salsa.",
                R.drawable.food_tacos,
                200,
                "Gastronomia"
            ),
            StandModel(
                "Asado",
                "La carne asada es una tradición añeja proveniente de las grandes extensiones fértiles de la llanura pampeana. Pero el asado argentino es más que la comida típica; es todo un ritual.",
                R.drawable.food_asado,
                300,
                "Gastronomia"
            ),
            StandModel(
                "Comida Vegana", "Una novedosa carta de comida vegana y productos sustentables",
                R.drawable.food_vegana,
                300,
                "Gastronomia"
            ),
            StandModel(
                "Licuados", "Veni a disfrutar nuestros licuados echos con fruta organica",
                R.drawable.food_licuados,
                200,
                "Gastronomia"
            ),
            StandModel(
                "Tiro al arco", "Proba tu destreza con el arco y llevate grandes premios",
                R.drawable.game_tiro_al_arco,
                200,
                "Juegos"
            ),
            StandModel(
                "Tumba Latas",
                "La actividad consiste en lanzar el elemento hacia las latas que se encuentran ordenadas en pirámide, sin sobrepasar la marca establecida. - Cada jugador tendrá tres intentos de lanzamiento hacia las latas con la finalidad de derribarlas.",
                R.drawable.game_tumbas_latas,
                200,
                "Juegos"
            ),
            StandModel(
                "Pesca",
                "Veni a probar tu destreza pescando y llevate el pez",
                R.drawable.game_pesca,
                200,
                "Juegos"
            ),
            StandModel(
                "Ruleta",
                "Veni a Probar tu suerte y llevate el gran premio secreto",
                R.drawable.game_ruleta,
                200,
                "Juegos"
            ),
        )
    }
}