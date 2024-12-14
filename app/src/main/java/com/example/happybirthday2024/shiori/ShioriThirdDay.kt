package com.example.happybirthday2024.shiori

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.happybirthday2024.AudioPlayerWithLoop
import com.example.happybirthday2024.Footer
import com.example.happybirthday2024.R

@Composable
fun ShioriThirdDay(onNavigateHome: () -> Unit,
                   onNavigateShiori: () -> Unit){
    val appThemeColor = Color(0xFF54AFC0)
    AudioPlayerWithLoop(R.raw.starsec4,0.2f,true)
    Surface( // 背景を設定する
        modifier = Modifier.fillMaxSize(),
        color = appThemeColor
    ){
        Scaffold(
            containerColor = Color.Transparent, // Scaffoldのデフォルト背景色を透明に設定
            bottomBar = { Footer(
                onNavigateShioriTop = onNavigateShiori,
                onNavigateHome = onNavigateHome
            ) } // フッターを指定
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                ModifierShioriThirdDayImage()
                MainShioriThirdDayMainView()
                MainShioriThirdDayFlowerView()

            }
        }
    }
}

@Composable
fun MainShioriThirdDayMainView(){
    val moon = painterResource(R.drawable.moon)
    val marioStar = painterResource(R.drawable.mariostar)
    val sunflower = painterResource(R.drawable.sunflower_squeare_imb)
    val pair = painterResource(R.drawable.pair)
    var isDialogOpen by remember { mutableStateOf(false) }
    val presentText : String = stringResource(R.string.presentMessageDay3Present)
    val presentThanksText : String = stringResource(R.string.presentMessageDay3Thanks)
    val presentTimeText : String = stringResource(R.string.presentPlanDay3Time)
    val presentPlaceText : String = stringResource(R.string.presentPlanDay3Place)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // 月を配置する
        Image(
            painter = moon,
            contentDescription = null,
            modifier = Modifier.size(120.dp).padding(15.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        // スターを配置する
        Image(
            painter = marioStar,
            contentDescription = null,
            modifier = Modifier.size(290.dp).clickable {
                isDialogOpen = true
            }
        )
        // 2人を配置する
        Image(
            painter = pair,
            contentDescription = null,
            modifier = Modifier
                .size(420.dp)
                .offset(0.dp,-90.dp)
        )

        if(isDialogOpen){
            Dialog(
                onDismissRequest = {}
            ){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFE599))
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
}

@Composable
fun MainShioriThirdDayFlowerView(){
    val flowerSize = Modifier.size(250.dp)
    // 花畑を配置する
    SunflowerComposable(flowerSize.offset(0.dp, 70.dp))
    SunflowerComposable(flowerSize.offset(30.dp,50.dp))
    SunflowerComposable(flowerSize.offset(60.dp,70.dp))
    SunflowerComposable(flowerSize.offset(90.dp,50.dp))
    SunflowerComposable(flowerSize.offset(120.dp, 30.dp))
    SunflowerComposable(flowerSize.offset(150.dp, 60.dp))
    SunflowerComposable(flowerSize.offset(180.dp, 70.dp))
}

@Composable
fun ModifierShioriThirdDayImage(){
    val cloudSmallImageModifier = Modifier.size(100.dp)
    val cloudMediumImageModifier = Modifier.size(120.dp)
    val cloudBigImageModifier = Modifier.size(170.dp)
    val starImageModifier = Modifier.size(65.dp)

    // 画面上部の大きい雲と星を配置する
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Row(){
            // 画面左の雲と星
            Column(){
                CloudComposable(cloudBigImageModifier.offset(10.dp,10.dp))
                StarComposable(starImageModifier.offset(40.dp,0.dp))
            }
            StarComposable(starImageModifier.offset(0.dp,100.dp))
            // 星
            // 画面右の雲と星
            Column(){
                CloudComposable(cloudBigImageModifier.offset(10.dp,50.dp))
                StarComposable(starImageModifier.offset(50.dp,0.dp))
            }
        }
        // 画面中部の中位雲を表示する
        CloudComposable(cloudMediumImageModifier.offset(20.dp))
        StarComposable(starImageModifier.offset(20.dp,0.dp))
        // 画面下部の小さい雲と星を表示する
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ){
            //小さい雲と星
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CloudComposable(cloudSmallImageModifier)
                StarComposable(starImageModifier)
            }
        }

    }


}