package com.tongsr.eyepetizer.business.home.dailyissue

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
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

    suspend fun getDailyIssueData(): SnapshotStateList<DailyIssueModel> {
        val dailyIssueData = service.getDailyIssueData()
        return dailyIssueData.itemList?.toMutableStateList() ?: mutableStateListOf()
    }

}