package com.tongsr.eyepetizer.business.home.dailyissue

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/29
 * @email ujffdtfivkg@gmail.com
 * @description 推荐 ViewModel
 */
class DailyIssueViewModel @AssistedInject constructor(
    @Assisted state: DailyIssueState,
    private val repository: DailyIssueRepository,
) : MavericksViewModel<DailyIssueState>(state) {

    init {
        getDailyIssueData()
    }

    fun getDailyIssueData() = withState { state ->
        if (state.dailyIssueListResult is Loading) return@withState
        suspend {
            repository.getDailyIssueData()
        }.execute {
            copy(dailyIssueListResult = it)
        }
    }

    /**
     * 这是重新赋值整个 list，所以会导致屏幕内可见的 item 刷新。
     */
    fun updateData(currentIndex: Int) = withState { state ->
        val currentList = state.dailyIssueListResult() ?: return@withState
        val currentDailyIssueModel = currentList[currentIndex]
        val newList = currentList.toMutableStateList()

        newList[currentIndex] = DailyIssueModel(
            data = Data(
                currentDailyIssueModel.data.id,
                currentDailyIssueModel.data.author,
                currentDailyIssueModel.data.category,
                currentDailyIssueModel.data.cover,
                currentDailyIssueModel.data.date,
                currentDailyIssueModel.data.description,
                currentDailyIssueModel.data.duration,
                "test title"
            )
        )
        setState {
            copy(dailyIssueListResult = Success(newList))
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<DailyIssueViewModel, DailyIssueState> {
        override fun create(state: DailyIssueState): DailyIssueViewModel

    }

    companion object :
        MavericksViewModelFactory<DailyIssueViewModel, DailyIssueState> by hiltMavericksViewModelFactory()

}