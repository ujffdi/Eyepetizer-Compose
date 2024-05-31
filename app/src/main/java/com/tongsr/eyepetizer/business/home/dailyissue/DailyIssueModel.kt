package com.tongsr.eyepetizer.business.home.dailyissue

/**
 * @author Tongsr
 * @date 2024/5/29
 * @description 日报 Model
 */

data class DailyIssueModel(
    val data: Data, val id: Int
)

data class Data(
    val id: Int? = 0,
    val author: Author? = null,
    val category: String? = null,
    val cover: Cover? = null,
    val date: Long? = null,
    val description: String? = null,
    var duration: Int? = null,
    val title: String? = null,
)

class Author(
    val description: String, val follow: Follow, val icon: String, val id: Int, val name: String
)

class Consumption(
    val collectionCount: Int, val realCollectionCount: Int, val replyCount: Int, val shareCount: Int
)

class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: String,
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