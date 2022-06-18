package com.example.carnaval.modelo

import com.example.carnaval.R

class StandCategoryProvider {
    companion object {

        val categorias = listOf<StandCategoryModel>(
            StandCategoryModel(
                "Juegos", "Un lugar donde podras encontrar divertirte y mostras tus destrezas",
                R.drawable.stand_kermes
            ),
            StandCategoryModel(
                "Gastronomia",
                "Un espacio gastronómico para vivir un encuentro de diversidad de culturas.",
                R.drawable.food_
            ),
            StandCategoryModel(
                "Eventos",
                "Es un lugar donde encontraras musica de todos los estilos; también hay actuaciones cómicas y de danza.",
                R.drawable.recital_lolla
            )
        )

    }
}