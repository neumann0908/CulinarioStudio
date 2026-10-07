package com.example.culinarystudio.data

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val difficulty: Int,
    val timeMin: Int,
    val calories: Int,
    val ingredients: List<String>,
    val steps: List<String>
)

data class UserStats(
    val level: Int,
    val xp: Int,
    val recipesCooked: Int,
    val highScore: Int
)
