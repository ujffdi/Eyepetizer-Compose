package com.tongsr.eyepetizer.business.home.dailyissue

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    Log.e("tongsr", "执行 DailyIssueScreen")

    val dailyIssueListResult by viewModel.collectAsState(DailyIssueState::dailyIssueListResult)

    when (dailyIssueListResult) {
        is Success -> {
            val listState = rememberLazyListState()

            LazyColumn(state = listState) {
                item {
                    Text(
                        text = stringResource(id = R.string.featured_short_videos),
                        modifier = Modifier
                            .padding(5.dp)
                            .wrapContentHeight(),
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                }
                items(dailyIssueListResult()?.size ?: 0) { index ->
                    val itemData = dailyIssueListResult()!![index].data
                    WinnowItem(
                        avatarUrl = itemData.author?.icon ?: "",
                        title = itemData.title ?: "",
                        subtitle = "${itemData.author?.name} #${itemData.category}       ▶${
                            secondsToHours(
                                itemData.duration ?: 0
                            )
                        }",
                        coverUrl = itemData.cover?.detail ?: ""
                    ) {
                        // 可以局部刷新
                        // 前提是用 SnapshotStateList
                        // SnapshotStateList 其实是 mutableStateListOf() 函数
                        // SnapshotStateList 可以监听内部属性的变化从而达到局部刷新的效果
                        dailyIssueListResult()!![index] = DailyIssueModel(
                            data = Data(
                                itemData.id,
                                itemData.author,
                                itemData.category,
                                itemData.cover,
                                itemData.date,
                                itemData.description,
                                itemData.duration,
                                "test title"
                            )
                        )

//                        viewModel.updateData(index)
                    }
                }
            }
        }

        is Fail -> Text(
            text = (dailyIssueListResult as? Fail<List<DailyIssueModel>>)?.error?.message ?: "error",
            modifier = Modifier.fillMaxSize(), fontSize = 18.sp, color = Color.Black
        )

        is Loading -> Text(
            text = stringResource(id = R.string.loading),
            modifier = Modifier.fillMaxSize(),
            fontSize = 18.sp,
            color = Color.Black
        )

        else -> {

        }

    }
}
