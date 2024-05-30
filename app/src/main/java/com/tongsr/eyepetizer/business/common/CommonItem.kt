package com.tongsr.eyepetizer.business.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.tongsr.eyepetizer.R

/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 通用的 Item
 */

/**
 * 精选 Item。
 */
@Composable
fun WinnowItem(
    avatarUrl: String,
    title: String,
    subtitle: String,
    coverUrl: String,
    clickable: (() -> Unit)? = null
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 30.dp)
            .clickable {
                clickable?.invoke()
            }
    ) {
        val (coverRef, titleRef, avatarRef, subtitleRef) = createRefs()

        AsyncImage(
            model = coverUrl,
            contentDescription = "cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(coverRef) {
                    top.linkTo(parent.top)
                },
            contentScale = ContentScale.Crop,
        )

        Image(painter = painterResource(id = R.drawable.ic_handpick_white),
            contentDescription = "winnow",
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(8.dp))

        AsyncImage(model = avatarUrl,
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(15.dp)
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .constrainAs(avatarRef) {
                    top.linkTo(coverRef.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                })

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, end = 5.dp)
                .constrainAs(titleRef) {
                    top.linkTo(avatarRef.top)
                    start.linkTo(avatarRef.end)
                    end.linkTo(parent.end)
                    // 设置宽度为 wrapContent 才能显示 ...
                    width = Dimension.preferredWrapContent
                },
            fontSize = 16.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontWeight = FontWeight.W600
        )

        Text(
            text = subtitle, modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(subtitleRef) {
                    start.linkTo(avatarRef.end)
                    top.linkTo(titleRef.bottom)
                }, fontSize = 14.sp
        )
    }
}
