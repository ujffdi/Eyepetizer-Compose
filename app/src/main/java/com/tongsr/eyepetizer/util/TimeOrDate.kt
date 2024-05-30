package com.tongsr.eyepetizer.util

import java.util.Locale

/**
 * @author Tongsr
 * @date 2024/5/30
 * @description 时间或者日期的工具类
 */

fun secondsToHours(seconds: Int): String {
    val hours = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format(Locale.US, "%01d:%02d", hours, remainingSeconds)
}
