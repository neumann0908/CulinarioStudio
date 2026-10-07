package com.example.culinarystudio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.culinarystudio.data.Recipe
import com.example.culinarystudio.ui.components.ArcadeCard
import com.example.culinarystudio.ui.theme.*

@Composable
fun RecipeDetailScreen(
    recipe: Recipe,
    onBack: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(DeepBlack).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text(text = recipe.title, fontFamily = PressStart2P, color = NeonMagenta, fontSize = 18.sp)
            Text(text = recipe.description, color = Color.Gray, fontFamily = ArcadeMono)
        }
        item {
            Text("INGREDIENTS", fontFamily = PressStart2P, color = PacmanYellow, fontSize = 14.sp)
            recipe.ingredients.forEach { ing ->
                Text("- $ing", color = Color.White, fontFamily = ArcadeMono)
            }
        }
        item {
            Text("STEPS", fontFamily = PressStart2P, color = PacmanYellow, fontSize = 14.sp)
            recipe.steps.forEachIndexed { index, step ->
                ArcadeCard { Text("${index + 1}. $step", color = NeonGreen, fontFamily = ArcadeMono) }
            }
        }
    }
}
