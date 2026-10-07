package com.example.culinarystudio.ui.screens

import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.culinarystudio.ui.components.ArcadeButton
import com.example.culinarystudio.ui.theme.DeepBlack
import com.example.culinarystudio.ui.theme.NeonMagenta
import com.example.culinarystudio.ui.theme.PressStart2P

@Composable
fun SplashScreen(onStart: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier.fillMaxSize().background(DeepBlack),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = "CULINARY\nSTUDIO",
                fontFamily = PressStart2P,
                color = NeonMagenta,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )
            Text(
                text = "INSERT COIN",
                fontFamily = PressStart2P,
                color = Color.White.copy(alpha = alpha),
                fontSize = 14.sp
            )
            ArcadeButton(
                text = "PRESS START",
                onClick = onStart,
                color = NeonMagenta
            )
        }
    }
}
