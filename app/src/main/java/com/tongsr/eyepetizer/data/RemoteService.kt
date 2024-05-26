package com.tongsr.eyepetizer.data

import com.tongsr.eyepetizer.business.home.recommended.RecommendedModel
import retrofit2.http.GET

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description 开眼 api
 */
interface RemoteService {

    /**
     * 获取推荐数据
     */
    @GET("/api/v4/tabs/selected")
    suspend fun getRecommendedData(): Any


}