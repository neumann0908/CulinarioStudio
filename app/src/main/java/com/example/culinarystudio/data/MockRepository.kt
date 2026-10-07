package com.example.culinarystudio.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object MockRepository {

    private val mockRecipes = listOf(
        Recipe(
            id = 1,
            title = "QUEST 01: NEO RAMEN",
            description = "Cyberpunk noodle soup with synthetic broth.",
            difficulty = 2,
            timeMin = 25,
            calories = 450,
            ingredients = listOf("Noodles", "Broth", "Egg"),
            steps = listOf("Boil water", "Add noodles", "Serve")
        ),
        Recipe(
            id = 2,
            title = "QUEST 02: PIXEL PIZZA",
            description = "8-bit style pepperoni pizza.",
            difficulty = 3,
            timeMin = 40,
            calories = 800,
            ingredients = listOf("Dough", "Sauce", "Cheese"),
            steps = listOf("Preheat oven", "Roll dough", "Bake 20m")
        )
    )

    val userStats = UserStats(level = 5, xp = 2400, recipesCooked = 12, highScore = 9500)

    fun getRecipes(): Flow<List<Recipe>> = flow {
        delay(800)
        emit(mockRecipes)
    }
}
