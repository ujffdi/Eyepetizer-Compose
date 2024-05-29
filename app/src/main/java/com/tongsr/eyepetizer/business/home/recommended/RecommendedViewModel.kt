package com.tongsr.eyepetizer.business.home.recommended

import android.util.Log
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.squareup.moshi.Moshi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description 推荐 ViewModel
 */
class RecommendedViewModel @AssistedInject constructor(
    @Assisted state: RecommendedState,
    private val repository: RecommendedRepository,
    val moshi: Moshi
) : MavericksViewModel<RecommendedState>(state) {

    init {
        getRecommendedData()
    }

    fun getRecommendedData() = withState { state ->
        if (state.model is Loading) return@withState
        suspend {
            repository.getRecommendedData()
        }.execute {
            copy(model = it)
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<RecommendedViewModel, RecommendedState> {
        override fun create(state: RecommendedState): RecommendedViewModel

    }

    companion object :
        MavericksViewModelFactory<RecommendedViewModel, RecommendedState> by hiltMavericksViewModelFactory()

}