package com.example.culinarystudio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.culinarystudio.data.Recipe
import com.example.culinarystudio.ui.components.ArcadeCard
import com.example.culinarystudio.ui.theme.*
import com.example.culinarystudio.viewmodel.MainViewModel
import com.example.culinarystudio.viewmodel.UiState

@Composable
fun RecipeListScreen(
    viewModel: MainViewModel = viewModel(),
    onRecipeClick: (Recipe) -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().background(DeepBlack).padding(16.dp)
    ) {
        Text(text = "QUEST LOG", fontFamily = PressStart2P, color = PacmanYellow, fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        when (val s = state) {
            is UiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = NeonGreen)
                }
            }
            is UiState.Success -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(s.recipes) { recipe ->
                        RecipeItem(recipe, onRecipeClick = { onRecipeClick(recipe) })
                        
                    }
                }
            }
            is UiState.Error -> {
                Text("CONNECTION ERROR", color = Color.Red, fontFamily = PressStart2P)
            }
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    ArcadeCard(
        modifier = Modifier.fillMaxWidth().clickable { onClick() }
    ) {
        Column {
            Text(text = recipe.title, fontFamily = PressStart2P, color = NeonGreen, fontSize = 14.sp)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("LVL ${recipe.difficulty}", color = CyberCyan, fontFamily = ArcadeMono, fontSize = 10.sp)
                Text("${recipe.timeMin} MIN", color = CyberCyan, fontFamily = ArcadeMono, fontSize = 10.sp)
            }
        }
    }
}
