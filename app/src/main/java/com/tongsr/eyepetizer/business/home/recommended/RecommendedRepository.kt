package com.tongsr.eyepetizer.business.home.recommended

import android.util.Log
import com.tongsr.eyepetizer.data.RemoteService
import javax.inject.Inject

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description RecommendedRepository
 */
class RecommendedRepository @Inject constructor(private val service: RemoteService) {

    suspend fun getRecommendedData(): Any {
        return service.getRecommendedData()
    }

}