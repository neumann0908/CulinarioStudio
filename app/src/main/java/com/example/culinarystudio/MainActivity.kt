package com.example.culinarystudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.culinarystudio.data.Recipe
import com.example.culinarystudio.ui.screens.*
import com.example.culinarystudio.ui.theme.CulinaryStudioTheme

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Dashboard : Screen("dashboard")
    object Recipes : Screen("recipes")
    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    object Settings : Screen("settings")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CulinaryStudioTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var selectedRecipe by remember { mutableStateOf<Recipe?>(null) }

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(onStart = { 
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                onNavigateToRecipes = { navController.navigate(Screen.Recipes.route) },
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) }
            )
        }
        composable(Screen.Recipes.route) {
            RecipeListScreen(
                onRecipeClick = { recipe ->
                    selectedRecipe = recipe
                    navController.navigate(Screen.Detail.createRoute(recipe.id))
                }
            )
        }
        composable(Screen.Detail.route) {
            selectedRecipe?.let { recipe ->
                RecipeDetailScreen(recipe = recipe, onBack = { navController.popBackStack() })
            }
        }
        composable(Screen.Settings.route) {
            SettingsScreen(
                stats = com.example.culinarystudio.data.MockRepository.userStats,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
