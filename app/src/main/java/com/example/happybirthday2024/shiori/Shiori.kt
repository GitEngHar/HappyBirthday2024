package com.example.happybirthday2024.shiori

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.happybirthday2024.AudioPlayerWithLoop
import com.example.happybirthday2024.Footer
import com.example.happybirthday2024.R
import com.example.happybirthday2024.VignetteBackground
import com.example.happybirthday2024.WavingImage

/*
* 全体を表示する関数
* Surface : 背景色の設定
* MainContent : メインで表示したい画面
* ModifierView : 画面の装飾
* */

@Composable
fun ShioriTop(
    onNavigateHome: () -> Unit,
    onNavigateShiori: () -> Unit,
    onNavigateShioriFirstDay: () -> Unit,
    onNavigateShioriSecondDay: () -> Unit,
    onNavigateShioriThirdDay: () -> Unit
    ){
    Box(modifier = Modifier.fillMaxSize()) {
        VignetteBackground()
        Scaffold(
            containerColor = Color.Transparent,// Scaffoldのデフォルト背景色を透明に設定
            bottomBar = { Footer(
                onNavigateHome = onNavigateHome,
                onNavigateShioriTop = onNavigateShiori) } // フッターを指定
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                ShioriMainView(
                    onNavigateShioriFirstDay,
                    onNavigateShioriSecondDay,
                    onNavigateShioriThirdDay
                )
            }
        }
    }
}

@Composable
fun ShioriMainView(
    onNavigateShioriFirstDay: () -> Unit,
    onNavigateShioriSecondDay: () -> Unit,
    onNavigateShioriThirdDay: () -> Unit
){
    val spacerModifier = Modifier.height(40.dp)
    val imageModifier = Modifier.size(180.dp)
    val doorFirst = painterResource(R.drawable.shiori1)
    val doorSecond = painterResource(R.drawable.shiori2)
    val doorThird = painterResource(R.drawable.shiori3)
    AudioPlayerWithLoop(R.raw.starsec0,0.2f,true)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start, //横
        verticalArrangement = Arrangement.Top //縦f
    ){
        Spacer(modifier = spacerModifier)
        Image(
            painter = doorThird,
            modifier = imageModifier.offset(30.dp).clickable{
                onNavigateShioriThirdDay()
            },
            contentDescription = "doorThird"
        )
        Spacer(modifier = spacerModifier)
        WavingImage(
            animationImage = doorSecond,
            modifier = imageModifier.offset(230.dp).clickable{
                onNavigateShioriSecondDay()
            },
            initialImageValue = 20f,
            targetImageValue = -10f,
            speed = 1200
        )

        Spacer(modifier = spacerModifier)
        WavingImage(
            animationImage = doorFirst,
            modifier = imageModifier.clickable{
                onNavigateShioriFirstDay()
            },
            initialImageValue = 0f,
            targetImageValue = 20f,
            speed = 1800
        )
    }
}

@Composable
fun ShioriModifierView(){

}