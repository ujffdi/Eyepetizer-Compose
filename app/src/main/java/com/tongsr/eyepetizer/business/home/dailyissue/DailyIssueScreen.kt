package com.tongsr.eyepetizer.business.home.dailyissue

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.mvrx.compose.mavericksViewModel
import com.tongsr.eyepetizer.R

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/20
 * @email ujffdtfivkg@gmail.com
 * @description 日报
 */
@Composable
fun DailyIssueScreen(viewModel: DailyIssueViewModel = mavericksViewModel()) {
    Text(
        text = stringResource(id = R.string.featured_short_videos),
        modifier = Modifier.padding(5.dp),
        fontSize = 18.sp
    )


}