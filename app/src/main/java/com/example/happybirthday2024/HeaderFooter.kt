package com.example.happybirthday2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Footer(
    onNavigateShioriTop: () -> Unit,
    onNavigateHome: () -> Unit
) {
    val shioriImage = painterResource(R.drawable._46927)
    val home = painterResource(R.drawable.home)
    Surface(
        color = Color(0xFFFFFFFF), // フッターの背景色（濃い緑）
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = home,
                contentDescription = null,
                modifier = Modifier.size(80.dp).wrapContentSize().clickable {
                    onNavigateHome()
                }
            )
            Image(
                painter = shioriImage,
                contentDescription = null,
                modifier = Modifier.size(80.dp).wrapContentSize().clickable{
                    /*画面遷移処理*/
                    onNavigateShioriTop()
                }
            )

        }
    }
}