package com.tongsr.eyepetizer.business.home.dailyissue

import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

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
        if (state.dailyIssueList is Loading) return@withState
        suspend {
            repository.getDailyIssueData()
        }.execute {
            copy(dailyIssueList = it)
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<DailyIssueViewModel, DailyIssueState> {
        override fun create(state: DailyIssueState): DailyIssueViewModel

    }

    companion object :
        MavericksViewModelFactory<DailyIssueViewModel, DailyIssueState> by hiltMavericksViewModelFactory()

}