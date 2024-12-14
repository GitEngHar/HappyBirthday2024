package com.example.happybirthday2024.shiori

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.happybirthday2024.AudioPlayerWithLoop
import com.example.happybirthday2024.Footer
import com.example.happybirthday2024.R

@Composable
fun ShioriFirstDay(
    onNavigateShiori: () -> Unit,
    onNavigateHome: () -> Unit
){
    val appThemeColor = Color(0x59d6f0ff)
    AudioPlayerWithLoop(R.raw.starsec2,0.2f,false)
    Surface( // 背景を設定する
        modifier = Modifier.fillMaxSize(),
        color = appThemeColor
    ){
        Scaffold(
            containerColor = Color.Transparent, // Scaffoldのデフォルト背景色を透明に設定
            bottomBar = { Footer(
                onNavigateHome = onNavigateHome,
                onNavigateShioriTop = onNavigateShiori
            ) } // フッターを指定
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                MainShioriFirstDayMainView()
                ModifierShioriFirstDayImage()
            }
        }
    }
}




@Composable
fun ModifierShioriFirstDayImage(){
    val starImageModifier = Modifier.size(80.dp)
    val cloudSmallImageModifier = Modifier.size(100.dp)
    val cloudMediumImageModifier = Modifier.size(160.dp)
    val cloudBigImageModifier = Modifier.size(200.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CloudComposable(cloudMediumImageModifier.offset(20.dp))
                StarComposable(starImageModifier.offset(0.dp,-50.dp))
            }
            Column(){
                CloudComposable(cloudSmallImageModifier.offset(60.dp,30.dp))
                CloudComposable(cloudMediumImageModifier.offset(80.dp))
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(){
            CloudComposable(cloudBigImageModifier.offset(0.dp,10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally){
                CloudComposable(cloudMediumImageModifier)
                StarComposable(starImageModifier.offset(0.dp,-50.dp))
            }

        }
    }
}

@Composable
fun ShioriFirstDayModal() {
    val sunflower = painterResource(R.drawable.sunflower_squeare_imb)
    var isDialogOpen by remember { mutableStateOf(false) }
    val shop = painterResource(R.drawable.star_shops)
    val shopImageModifier = Modifier.size(300.dp)
    val presentText : String = stringResource(R.string.presentMessageDay1Present)
    val presentThanksText : String =stringResource(R.string.presentMessageDay1Thanks)
    val presentTimeText : String =stringResource(R.string.presentPlanDay1Time)
    val presentPlaceText : String =stringResource(R.string.presentPlanDay1Place)

    Image(
        painter = shop,
        modifier = shopImageModifier
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                isDialogOpen = true
            }, //clip RoundedCornerShapeで角を丸くする
        contentDescription = null
    )

    if(isDialogOpen){
        Dialog(
            onDismissRequest = {}
        ){
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFBEB71))
                .padding(8.dp),
            ){
                Column(
                    modifier = Modifier.padding(8.dp)
                ){
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFFFFF), //不透明度 RGB
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(375.dp)
                            .padding(8.dp),
                    ){

                        ShioriTextComposable(
                            presentText = presentText,
                            presentThanksText = presentThanksText,
                            presentTimeText = presentTimeText,
                            presentPlaceText = presentPlaceText
                        )
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Bottom
                        ){
                            TextButton(
                                onClick = {isDialogOpen = false},
                                modifier = Modifier.padding(5.dp),
                            ){
                                Text("close")
                            }
                            modalImageCompose(
                                modalImage = sunflower,
                                modifier = Modifier.size(200.dp).offset(15.dp,0.dp)
                            )
                        }

                    }
                }

            }
        }
    }

}

@Composable
fun MainShioriFirstDayMainView(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        ShioriFirstDayModal()
    }
}