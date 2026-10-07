package com.example.culinarystudio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.culinarystudio.data.UserStats
import com.example.culinarystudio.ui.components.ArcadeCard
import com.example.culinarystudio.ui.theme.*

@Composable
fun SettingsScreen(
    stats: UserStats,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(DeepBlack).padding(16.dp)
    ) {
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
        }
        Text(text = "PLAYER 1 STATS", fontFamily = PressStart2P, color = CyberCyan, fontSize = 20.sp, modifier = Modifier.padding(vertical = 16.dp))
        ArcadeCard {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                StatRow("LEVEL", stats.level.toString())
                StatRow("XP", stats.xp.toString())
                StatRow("QUESTS", stats.recipesCooked.toString())
            }
        }
    }
}

@Composable
fun StatRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = Color.Gray, fontFamily = ArcadeMono, fontSize = 12.sp)
        Text(value, color = NeonMagenta, fontFamily = PressStart2P, fontSize = 14.sp)
    }
}
