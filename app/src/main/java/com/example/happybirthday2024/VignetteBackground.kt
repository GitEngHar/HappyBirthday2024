package com.example.happybirthday2024

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun VignetteBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val radius = size.maxDimension * 0.6f
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFF322211), // 中央の焦茶色
                    Color(0xFF000000) // 外周の黒
                ),
                center = center,
                radius = radius
            ),
            center = center,
            radius = radius
        )
    }
}
