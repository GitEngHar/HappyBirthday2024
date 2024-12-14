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
import androidx.compose.foundation.shape.CircleShape
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
fun ShioriSecondDay(onNavigateHome:()-> Unit,onNavigateShiori: () -> Unit){
    // 0a2d45ff
    val appThemeColor = Color(0xFF012233)
    AudioPlayerWithLoop(R.raw.starsec3,0.2f,true)
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
                MainShioriSecondDayMainView()
                ModifierShioriSecondDayImage()
            }
        }
    }
}

@Composable
fun ModifierShioriSecondDayImage(){
    val cloud = painterResource(R.drawable.cloud_squeare2)
    val cloudSmallImageModifier = Modifier.size(100.dp)
    val cloudMediumImageModifier = Modifier.size(150.dp)
    val cloudBigImageModifier = Modifier.size(200.dp)
    val starImageModifier = Modifier.size(70.dp)
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ){
        Column(){
            Image(
                painter = cloud,
                contentDescription = null,
                modifier = cloudBigImageModifier
            )
            StarComposable(starImageModifier.offset(10.dp,-50.dp))
        }
        StarComposable(starImageModifier.offset(0.dp,30.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = cloud,
                contentDescription = null,
                modifier = cloudMediumImageModifier.offset(-20.dp)
            )
            Image(
                painter = cloud,
                contentDescription = null,
                modifier = cloudSmallImageModifier.offset(-10.dp,-80.dp)
            )
        }
    }
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Spacer(modifier = Modifier.height(370.dp))
        StarComposable(starImageModifier.offset(160.dp))
        StarComposable(starImageModifier.offset(10.dp))
        StarComposable(starImageModifier.offset(330.dp))

    }
}

@Composable
fun MainShioriSecondDayMainView(){
    val bus = painterResource(R.drawable.gotoosaka)
    val spaWorld = painterResource(R.drawable.spaworld)
    val park = painterResource(R.drawable.park)
    val hotel = painterResource(R.drawable.hotelroom)
    val tokitoki = painterResource(R.drawable.escape)
    val imageModifier = Modifier.size(150.dp)
    val cloud = painterResource(R.drawable.cloud_squeare2)
    val cloudMediumImageModifier = Modifier.size(150.dp)
    val cloudBigImageModifier = Modifier.size(200.dp)
    val moon = painterResource(R.drawable.moon)
    var isDialogOpen by remember { mutableStateOf(false) }

    // モーダル表示用
    var resourceNumber by remember { mutableStateOf(0) }
    val presentArray = arrayOf(
        stringResource(R.string.presentMessageDay2BusPresent),
        stringResource(R.string.presentMessageDay2ParkPresent),
        stringResource(R.string.presentMessageDay2TokiTokiPresent),
        stringResource(R.string.presentMessageDay2SpaPresent),
        stringResource(R.string.presentMessageDay2HotelPresent)
    )
    val presentThanksArray = arrayOf(
        stringResource(R.string.presentMessageDay2BusThanks),
        stringResource(R.string.presentMessageDay2ParkThanks),
        stringResource(R.string.presentMessageDay2TokiTokiThanks),
        stringResource(R.string.presentMessageDay2SpaThanks),
        stringResource(R.string.presentMessageDay2HotelThanks)
    )
    val presentTimeArray = arrayOf(
        stringResource(R.string.presentPlanDay2BusTime),
        stringResource(R.string.presentPlanDay2ParkTime),
        stringResource(R.string.presentPlanDay2TokiTokiTime),
        stringResource(R.string.presentPlanDay2SpaTime),
        stringResource(R.string.presentPlanDay2HotelTime)
    )
    val presentPlaceArray = arrayOf(
        stringResource(R.string.presentPlanDay2BusPlace),
        stringResource(R.string.presentPlanDay2ParkPlace),
        stringResource(R.string.presentPlanDay2TokiTokiPlace),
        stringResource(R.string.presentPlanDay2SpaPlace),
        stringResource(R.string.presentPlanDay2HotelPlace)
    )

    Row (
        modifier = Modifier.fillMaxSize() ,
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
    ){
        Image(
            painter = spaWorld,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
                .offset(30.dp,250.dp)
                .clip(CircleShape)
                .clickable {
                    isDialogOpen = true
                    resourceNumber = 3
                }

        )
        Image(
            painter = hotel,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
                .offset(60.dp,170.dp)
                .clip(CircleShape)
                .clickable {
                    isDialogOpen = true
                    resourceNumber = 4
                }
        )
    }
    Column(
        modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ){
        Image(
            painter = tokitoki,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
                .offset(-10.dp,10.dp)
                .clip(CircleShape)
                .clickable {
                    isDialogOpen = true
                    resourceNumber = 2
                }
        )
    }

    /*
    * バスとparkの最下部表示
    * */
    Column(
        modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ){
        Row(){
            /*
            * バスの画像表示
            * */
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = bus,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                        .offset(10.dp,110.dp)
                        .clip(CircleShape)
                        .clickable {
                        isDialogOpen = true
                        resourceNumber = 0
                    }

                )
                Image(
                    painter = cloud,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = cloudMediumImageModifier
                        .offset(10.dp,60.dp)
                        .clip(CircleShape)
                )

            }

            /*
            * parkの表示
            * */
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = park,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                        .offset(50.dp,50.dp)
                        .clip(CircleShape)
                        .clickable {
                            isDialogOpen = true
                            resourceNumber = 1
                        }
                )
                Image(
                    painter = cloud,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = cloudBigImageModifier.offset(40.dp,0.dp).clip(CircleShape)
                )
            }
        }
    }

    /*
    * モーダルの表示部分
    * */
    if(isDialogOpen){
        Dialog(
            onDismissRequest = {}
        ){
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB4A7D6))
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
                            presentText = presentArray[resourceNumber],
                            presentThanksText = presentThanksArray[resourceNumber],
                            presentTimeText = presentTimeArray[resourceNumber],
                            presentPlaceText = presentPlaceArray[resourceNumber]
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
                                modalImage = moon,
                                modifier = Modifier.size(75.dp).offset(100.dp,0.dp)
                            )
                        }

                    }
                }

            }
        }
    }
}
