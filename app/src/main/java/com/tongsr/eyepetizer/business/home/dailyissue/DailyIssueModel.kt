package com.tongsr.eyepetizer.business.home.dailyissue

/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 日报 Model
 */

class DailyIssueModel(
    val data: Data
)

class Data(
    val id: Int? = null,
    val author: Author? = null,
    val category: String? = null,
    val cover: Cover? = null,
    val date: Long? = null,
    val description: String? = null,
    val duration: Int? = null,
    val title: String? = null,
)

class Author(
    val icon: String, val name: String? = null
)

class Cover(
    val blurred: String ? = null,
    val detail: String? = null,
    val feed: String? = null,
    val homepage: String? = null,
)

class Provider(
    val alias: String, val icon: String, val name: String
)

class Tag(
    val actionUrl: String,
    val bgPicture: String,
    val communityIndex: Int,
    val desc: String? = null,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val name: String,
    val tagRecType: String
)

class WebUrl(
    val forWeibo: String, val raw: String
)

class Follow(
    val followed: Boolean, val itemId: Int, val itemType: String
)

class Shield(
    val itemId: Int, val itemType: String, val shielded: Boolean
)