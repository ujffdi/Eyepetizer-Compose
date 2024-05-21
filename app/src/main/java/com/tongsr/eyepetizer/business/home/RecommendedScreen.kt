package com.tongsr.eyepetizer.business.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.tongsr.eyepetizer.R

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/20
 * @email ujffdtfivkg@gmail.com
 * @description 推荐页面
 */
@Composable
fun RecommendedScreen() {
    LazyColumn {
        items(20) {
            WinnowItem()
        }
    }
}

/**
 * 精选 Item。
 */
@Composable
fun WinnowItem() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 30.dp)
    ) {
        val (image, title, avatar, subtitle, duration) = createRefs()

        Image(painter = rememberAsyncImagePainter("https://img.lamilive.com/FuvHZylf2yFZZ2uoj8wKBqUjaczF?imageslim"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                })

        Image(painter = painterResource(id = R.drawable.ic_handpick_white),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(8.dp))

        Image(painter = rememberAsyncImagePainter("https://img.lamilive.com/FghiYJPYu7VaVQ0ttinv73q6KGZd?imageslim"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(15.dp)
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .constrainAs(avatar) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                })

        Text(text = "吓到腿软！世界最长的跳台滑雪记录",
            modifier = Modifier
                .padding(top = 18.dp)
                .constrainAs(title) {
                    top.linkTo(avatar.top)
                    start.linkTo(avatar.end)
                }, fontSize = 16.sp
        )

        Text(text = "开眼运动精选 #运动",
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(subtitle) {
                    start.linkTo(avatar.end)
                    top.linkTo(title.bottom)
                }, fontSize = 14.sp
        )

        Text(text = "▶ 08:11", modifier = Modifier
            .padding(start = 20.dp)
            .constrainAs(duration) {
                bottom.linkTo(subtitle.bottom)
                start.linkTo(subtitle.end)
            }, fontSize = 14.sp
        )
    }
}

@Preview
@Composable
fun PreviewWinnowItem() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        WinnowItem()
    }
}