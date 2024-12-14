package com.example.happybirthday2024

import android.media.MediaPlayer
import android.media.VolumeShaper
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun AudioPlayerWithLoop(
    music: Int,
    volume:Float,
    isFadeIn: Boolean
) {
    val context = LocalContext.current // Contextを取得
    val mediaPlayer = remember { MediaPlayer.create(context, music).apply {
        isLooping = true // ループ再生を有効化
    }}

    mediaPlayer.setVolume(volume,volume)
    // 初期化時に再生を開始
    LaunchedEffect(Unit) {
        if(isFadeIn){
            val config : VolumeShaper.Configuration = VolumeShaper.Configuration.Builder()
                .setDuration(9000)
                .setCurve(floatArrayOf(0f, 1f), floatArrayOf(0f, volume))
                .setInterpolatorType(VolumeShaper.Configuration.INTERPOLATOR_TYPE_LINEAR)
                .build()
            val volumeShaper = mediaPlayer.createVolumeShaper(config)
            mediaPlayer.start()
            volumeShaper.apply(VolumeShaper.Operation.PLAY)
        }else{
            mediaPlayer.start()
        }
    }
    // MediaPlayerのリソース解放
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
}
