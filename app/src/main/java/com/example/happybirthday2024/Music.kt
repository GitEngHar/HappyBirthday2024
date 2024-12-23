package com.example.happybirthday2024

import android.media.MediaPlayer
import android.media.VolumeShaper
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun AudioPlayerWithLoop(
    music: Int,
    volume: Float,
    isFadeIn: Boolean
) {
    val context = LocalContext.current // Contextを取得
    val lifecycleOwner = LocalLifecycleOwner.current // LifecycleOwnerを取得
    val mediaPlayer = remember {
        MediaPlayer.create(context, music).apply {
            isLooping = true // ループ再生を有効化
        }
    }

    mediaPlayer.setVolume(volume, volume)

    // 初期化時にLifecycleに応じて再生制御
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    // アクティビティがフォアグラウンドに戻った場合に再生
                    if (isFadeIn) {
                        val config: VolumeShaper.Configuration = VolumeShaper.Configuration.Builder()
                            .setDuration(9000)
                            .setCurve(floatArrayOf(0f, 1f), floatArrayOf(0f, volume))
                            .setInterpolatorType(VolumeShaper.Configuration.INTERPOLATOR_TYPE_LINEAR)
                            .build()
                        val volumeShaper = mediaPlayer.createVolumeShaper(config)
                        mediaPlayer.start()
                        volumeShaper.apply(VolumeShaper.Operation.PLAY)
                    } else {
                        mediaPlayer.start()
                    }
                }
                Lifecycle.Event.ON_PAUSE -> {
                    // アクティビティがバックグラウンドに移行した場合に停止
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.pause()
                    }
                }
                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        // MediaPlayerのリソース解放
        onDispose {
            mediaPlayer.release()
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
