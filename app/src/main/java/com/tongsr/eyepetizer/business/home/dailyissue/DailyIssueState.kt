package com.tongsr.eyepetizer.business.home.dailyissue

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized

/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 日报 State
 */
data class DailyIssueState(
    val dailyIssueListResult: Async<SnapshotStateList<DailyIssueModel>> = Uninitialized
) : MavericksState