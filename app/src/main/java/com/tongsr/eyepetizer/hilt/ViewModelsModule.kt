package com.tongsr.eyepetizer.hilt

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import com.tongsr.eyepetizer.business.home.dailyissue.DailyIssueViewModel
import com.tongsr.eyepetizer.business.home.recommended.RecommendedViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description ViewModelsModule
 */
@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecommendedViewModel::class)
    fun recommendedViewModelFactory(factory: RecommendedViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(DailyIssueViewModel::class)
    fun dailyIssueViewModelFactory(factory: DailyIssueViewModel.Factory): AssistedViewModelFactory<*, *>

}