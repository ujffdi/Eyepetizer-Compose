package com.tongsr.eyepetizer.data


/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 数据的外壳
 */

class BaseModel<T>(
    val adExist: Boolean,
    val count: Int,
    val date: Long,
    val itemList: List<T>? = null,
    val lastStartId: Int,
    val nextPageUrl: String? = null,
    val nextPublishTime: Long,
    val refreshCount: Int,
    val total: Int
)