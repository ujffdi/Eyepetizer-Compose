package com.tongsr.eyepetizer.business.home.recommended

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.squareup.moshi.Moshi
import com.tongsr.eyepetizer.R

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/20
 * @email ujffdtfivkg@gmail.com
 * @description 推荐页面
 */
@Composable
fun RecommendedScreen(
    viewModel: RecommendedViewModel = mavericksViewModel()
) {
    val model by viewModel.collectAsState(RecommendedState::model)

    when (model) {
        is Loading -> {
            Text(text = "加载中11", modifier = Modifier
                .fillMaxSize())
        }

        is Success -> {
            AnimatedVisibility(visible = true) {
                Text(text = "1111${model().toString()}", modifier = Modifier
                    .fillMaxSize())
            }
        }

        is Fail -> {

        }
        Uninitialized -> {

        }
    }

//    LazyColumn {
//        items(20) {
//            WinnowItem()
//        }
//    }
}
