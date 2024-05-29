package com.tongsr.eyepetizer.business.home.dailyissue

import com.google.common.collect.ImmutableList
import com.tongsr.eyepetizer.data.RemoteService
import javax.inject.Inject

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description RecommendedRepository
 */
class DailyIssueRepository @Inject constructor(private val service: RemoteService) {

    suspend fun getDailyIssueData(): ImmutableList<DailyIssueModel> {
        val dailyIssueData = service.getDailyIssueData()
        return dailyIssueData.itemList ?: ImmutableList.of()
    }

}