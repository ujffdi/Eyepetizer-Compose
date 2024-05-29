package com.tongsr.eyepetizer.business.home.dailyissue

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.google.common.collect.ImmutableList

/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 日报 State
 */
data class DailyIssueState(val dailyIssueList: Async<ImmutableList<DailyIssueModel>> = Uninitialized) :
    MavericksState