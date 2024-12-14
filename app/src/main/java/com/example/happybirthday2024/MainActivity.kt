package com.example.happybirthday2024


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday2024.ui.theme.HappyBirthday2024Theme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.happybirthday2024.shiori.ShioriFirstDay
import com.example.happybirthday2024.shiori.ShioriSecondDay
import com.example.happybirthday2024.shiori.ShioriThirdDay
import com.example.happybirthday2024.shiori.ShioriTop

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthday2024Theme {
                val navController = rememberNavController() //NavControllerを定義する
                NavHost(
                    navController= navController,
                    startDestination = Nav.Home.name
                ){
                    composable(route = Nav.Home.name){
                        Home(
                            onNavigateShiori = {navController.navigate(Nav.ShioriTop.name)},
                            onNavigateHome = {navController.navigate(Nav.Home.name)}
                        )
                    }
                    composable(route = Nav.ShioriTop.name){
                        ShioriTop(
                            onNavigateShiori = {navController.navigate(Nav.ShioriTop.name)},
                            onNavigateHome = {navController.navigate(Nav.Home.name)},
                            onNavigateShioriFirstDay = {navController.navigate(Nav.ShioriFirstDay.name)},
                            onNavigateShioriSecondDay = {navController.navigate(Nav.ShioriSecondDay.name)},
                            onNavigateShioriThirdDay = {navController.navigate(Nav.ShioriThirdDay.name)}
                        )
                    }
                    composable(route = Nav.ShioriFirstDay.name) {
                        ShioriFirstDay(
                            onNavigateShiori = {navController.navigate(Nav.ShioriTop.name)},
                            onNavigateHome = {navController.navigate(Nav.Home.name)}
                        )
                    }
                    composable(route = Nav.ShioriSecondDay.name) {
                        ShioriSecondDay(
                            onNavigateShiori = {navController.navigate(Nav.ShioriTop.name)},
                            onNavigateHome = {navController.navigate(Nav.Home.name)}
                        )
                    }
                    composable(route = Nav.ShioriThirdDay.name) {
                        ShioriThirdDay(
                            onNavigateShiori = {navController.navigate(Nav.ShioriTop.name)},
                            onNavigateHome = {navController.navigate(Nav.Home.name)}
                        )
                    }
                }
            }
        }
    }
}

open class CountTripBirthDay(){
    //今日の日付を取得する
    var differenceInDays : Int = 0
        set(value){
            if (value > 0){
                field = value
            }
        }
    //残りの日付をカウントする
    constructor(tripDay: String) :this(){
        val onlyDateNow: LocalDate = LocalDate.now()
        val localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val tripDate = LocalDate.parse(tripDay,localDateFormatter)
        differenceInDays = ChronoUnit.DAYS.between(onlyDateNow,tripDate).toInt()
    }
}

@Composable
fun Home(
    onNavigateShiori: () -> Unit,
    onNavigateHome: () -> Unit
) {
    val appThemeColor = Color(0xFFFFDDE2)
    AudioPlayerWithLoop(R.raw.canonpiano,1f,false)
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
                MainContent()
                ModifierView()
            }
        }
    }
}

@Composable
fun MainContent(){


    val mainImageModifier = Modifier.size(300.dp)
    val countTripBirthDay =  CountTripBirthDay("2025-02-20")
    val favoriteImages = arrayOf(
        painterResource(R.drawable.mainimage),
        painterResource(R.drawable.fav0),
        painterResource(R.drawable.fav1),
        painterResource(R.drawable.fav2),
        painterResource(R.drawable.fav4),
        painterResource(R.drawable.fav5),
        painterResource(R.drawable.fav6),
        painterResource(R.drawable.fav7),
        painterResource(R.drawable.fav8),
        painterResource(R.drawable.fav9),
        painterResource(R.drawable.fav10),
        painterResource(R.drawable.fav11),
        painterResource(R.drawable.fav12),
        painterResource(R.drawable.fav13),
        painterResource(R.drawable.fav14),
        painterResource(R.drawable.fav17),
        painterResource(R.drawable.fav19),
        painterResource(R.drawable.fav20),
    )
    var favImageNumber by remember { mutableStateOf((0..favoriteImages.size-1).random()) }
    /*
    * テキスト メイン画像の表示レイヤー
    * */
    val cicleFlower = painterResource(R.drawable.homemod3);
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text = stringResource(R.string.birthday),
            fontSize = 40.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.offset(0.dp,70.dp)
        )
        Text(
            text = stringResource(R.string.birthdayword),
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.offset(0.dp,90.dp)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            painter = favoriteImages[favImageNumber],
            contentDescription = null,
            contentScale  = ContentScale.Crop,
            modifier = mainImageModifier.offset(0.dp,-60.dp).clickable {
                if(favImageNumber >= favoriteImages.size-1){
                    favImageNumber = 0
                }else{
                    favImageNumber +=1
                }
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Image(
            painter = cicleFlower,
            contentDescription = null,
            contentScale  = ContentScale.Crop,
            modifier = Modifier.size(250.dp).offset(0.dp, 20.dp)
        )
        Text(
            text = stringResource(R.string.trip),
            fontSize = 20.sp,
            modifier = Modifier.offset(0.dp,-130.dp)
        )
        Text(
            text = " ${countTripBirthDay.differenceInDays} 日",
            fontSize = 30.sp,
            modifier = Modifier.offset(0.dp,-130.dp)
        )

    }
}

@Composable
fun ModifierView(){
    val bird = painterResource(R.drawable.homemod1);
    val leftBird = painterResource(R.drawable.homemod2)
    /*
    * 装飾表示レイヤー
    * */
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start, //横
        verticalArrangement = Arrangement.Top //縦
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = leftBird,
            contentDescription = null,
            contentScale  = ContentScale.Crop,
            modifier = Modifier.size(100.dp).offset(20.dp, 135.dp)
        )
        Image(
            painter = bird,
            contentDescription = null,
            contentScale  = ContentScale.Crop,
            modifier = Modifier.size(80.dp).offset(300.dp, 330.dp)
        )

    }
}


