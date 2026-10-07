package com.example.culinarystudio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.culinarystudio.ui.components.ArcadeCard
import com.example.culinarystudio.ui.theme.*

@Composable
fun DashboardScreen(
    onNavigateToRecipes: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(DeepBlack).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "SELECT STAGE", fontFamily = PressStart2P, color = NeonGreen, fontSize = 20.sp)
        DashboardItem("RECIPE QUESTS", Icons.Default.List, NeonGreen, onNavigateToRecipes)
        DashboardItem("CHEF PROFILE", Icons.Default.Person, CyberCyan, onNavigateToSettings)
    }
}

@Composable
fun DashboardItem(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, color: Color, onClick: () -> Unit) {
    ArcadeCard(
        modifier = Modifier.fillMaxWidth().height(80.dp).clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(32.dp))
            Text(text = title, fontFamily = PressStart2P, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}
