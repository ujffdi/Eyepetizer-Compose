package com.tongsr.eyepetizer.business.home.dailyissue

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
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

    fun getDailyIssueData() {
        viewModelScope.launch {
            val dailyIssueData = repository.getDailyIssueData()
            setState {
                copy(dailyIssueList = dailyIssueData)
            }
        }
    }

    fun update(id: Int) = withState { state ->
        setState {
            val newList = state.dailyIssueList.mapIndexed { index, dailyIssueModel ->
                if (index == id) {
                    dailyIssueModel.copy(data = dailyIssueModel.data.copy(duration = 600))
                } else {
                    dailyIssueModel
                }
            }
            copy(dailyIssueList = newList)
        }
    }


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<DailyIssueViewModel, DailyIssueState> {
        override fun create(state: DailyIssueState): DailyIssueViewModel

    }

    companion object :
        MavericksViewModelFactory<DailyIssueViewModel, DailyIssueState> by hiltMavericksViewModelFactory()

}