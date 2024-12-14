package com.example.happybirthday2024.shiori

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday2024.R
import com.example.happybirthday2024.TwinklingStar

@Composable
fun CloudComposable(modifier: Modifier){
    val cloud = painterResource(R.drawable.cloud_squeare2)
    Image(
        painter = cloud,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun StarComposable(modifier: Modifier){
    val star = painterResource(R.drawable.star_suqeare)
    TwinklingStar(star,modifier)
//    Image(
//        painter = star,
//        contentDescription = null,
//        modifier = modifier
//    )
}

@Composable
fun ShioriTextComposable(presentText: String,
                         presentThanksText: String,
                         presentTimeText: String,
                         presentPlaceText: String,
                         ){
    Column(
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text = stringResource(R.string.presenttitle),
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily.Serif,
            ),
            modifier = Modifier.padding(16.dp).align(alignment = Alignment.CenterHorizontally),
        )
        Column(
            horizontalAlignment = Alignment.Start,

            ){
            Text(
                text = presentText,
                modifier = Modifier.padding(16.dp,16.dp,16.dp,8.dp),
            )
            Text(
                text = presentThanksText,
                modifier = Modifier.padding(16.dp,8.dp,16.dp,8.dp),
            )
            Text(
                text = presentTimeText,
                modifier = Modifier.padding(16.dp,8.dp,16.dp,8.dp),
            )
            Text(
                text = presentPlaceText,
                modifier = Modifier.padding(16.dp,8.dp,16.dp,8.dp),
            )
        }

    }
}

@Composable
fun SunflowerComposable(sunFlowerModifier: Modifier){
    val sunFlower = painterResource(R.drawable.sunflower_squeare_imb)
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start
    ){
        Image(
            painter = sunFlower,
            modifier = sunFlowerModifier,
            contentDescription = null
        )
    }
}

@Composable
fun modalImageCompose(modalImage: Painter, modifier: Modifier){
    Image(
        painter = modalImage,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
