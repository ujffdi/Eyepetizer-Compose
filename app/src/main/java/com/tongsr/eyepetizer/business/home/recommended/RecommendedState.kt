package com.tongsr.eyepetizer.business.home.recommended

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description RecommendedState
 */
data class RecommendedState(val model: Async<Any> = Uninitialized) : MavericksState