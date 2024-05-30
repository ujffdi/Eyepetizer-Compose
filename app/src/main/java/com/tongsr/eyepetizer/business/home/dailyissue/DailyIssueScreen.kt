package com.tongsr.eyepetizer.business.home.dailyissue

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.tongsr.eyepetizer.R
import com.tongsr.eyepetizer.business.common.WinnowItem
import com.tongsr.eyepetizer.util.secondsToHours

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/20
 * @email ujffdtfivkg@gmail.com
 * @description 日报界面
 */
@Composable
fun DailyIssueScreen(viewModel: DailyIssueViewModel = mavericksViewModel()) {
    val async by viewModel.collectAsState(DailyIssueState::dailyIssueList)
    when(async) {
        is Success -> {
            val listState = rememberLazyListState()

            async()?.let { list ->
                LazyColumn(state = listState) {

                    item {
                        Text(
                            text = stringResource(id = R.string.featured_short_videos),
                            modifier = Modifier
                                .padding(5.dp)
                                .wrapContentHeight(),
                            fontSize = 18.sp
                        )
                    }

                    items(list) {
                        val data = it.data
                        WinnowItem(
                            avatarUrl = data.author?.icon ?: "",
                            title = data.title ?: "",
                            subtitle = "${data.author?.name} #${data.category}       ▶${secondsToHours(data.duration ?: 0)}",
                            coverUrl = data.cover?.detail ?: ""
                        )
                    }
                }
            }
        }
        is Fail -> {
            Text(
                text = (async as? Fail<List<DailyIssueModel>>)?.error?.message ?: "error",

                modifier = Modifier.fillMaxSize(),
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        is Loading -> {
            Text(
                text = stringResource(id = R.string.loading),
                modifier = Modifier.fillMaxSize(),
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        else -> {

        }
    }

}