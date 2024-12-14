package com.example.happybirthday2024

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun WavingImage(animationImage : Painter,modifier:Modifier,
                initialImageValue: Float,
                targetImageValue: Float,
                speed: Int
                ) {
    // 無限アニメーションの設定
    val infiniteTransition = rememberInfiniteTransition()

    // アニメーションのオフセット値
    val offsetY = infiniteTransition.animateFloat(
        initialValue = initialImageValue,
        targetValue = targetImageValue, // 上下の移動幅 (dp)
        animationSpec = infiniteRepeatable(
            animation = tween(speed, easing = LinearEasing), // 1秒で上下移動
            repeatMode = RepeatMode.Reverse
        )
    )

    // 画像を上下に動かす
    Image(
        painter = animationImage, // 画像リソースを指定
        contentDescription = "Waving Image",
        modifier = modifier
            .offset(y = offsetY.value.dp) // Y方向に動かす
    )
}

@Composable
fun TwinklingStar(animationImage : Painter,modifier:Modifier,) {
    // 無限アニメーションの設定
    val infiniteTransition = rememberInfiniteTransition()

    // アルファ値（透明度）のアニメーション
    val alpha = infiniteTransition.animateFloat(
        initialValue = 0.15f, // 半透明
        targetValue = 1f, // 完全に見える
        animationSpec = infiniteRepeatable(
            animation = tween(700, easing = LinearEasing), // 1秒で変化
            repeatMode = RepeatMode.Reverse
        )
    )

    // 星を描画
    Image(
        painter = animationImage, // 星の画像を指定
        contentDescription = "Twinkling Star",
        modifier = modifier.graphicsLayer(alpha = alpha.value) // 透明度を設定
    )
}