package com.tongsr.eyepetizer.business.home.dailyissue

import com.airbnb.mvrx.MavericksState

/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 日报 State
 */
data class DailyIssueState(val dailyIssueList: List<DailyIssueModel> = emptyList()) :
    MavericksState