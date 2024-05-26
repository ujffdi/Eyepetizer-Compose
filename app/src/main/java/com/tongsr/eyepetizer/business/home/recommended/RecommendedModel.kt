package com.tongsr.eyepetizer.business.home.recommended

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/26
 * @email ujffdtfivkg@gmail.com
 * @description 推荐数据 Model
 */
data class RecommendedModel(
    val adExist: Boolean,
    val count: Int,
    val date: Long,
    val itemList: List<Item>,
    val lastStartId: Int,
    val nextPageUrl: String,
    val nextPublishTime: Long,
    val refreshCount: Int,
    val total: Int
)

data class Item(
    val adIndex: Int,
    val data: Data,
    val id: Int,
    val tag: String,
    val type: String
)

data class Data(
    val actionUrl: String? = null,
    val ad: Boolean,
    val author: Author,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: String,
    val duration: Int,
    val font: String? =  null,
    val header: Header? = null,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val itemList: List<Item>? = null,
    val library: String,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val provider: ProviderX,
    val reallyCollected: Boolean,
    val releaseTime: Long,
    val remark: String,
    val resourceType: String,
    val searchWeight: Int,
    val slogan: String? = null,
    val tags: List<Tag>,
    val text: String? = null,
    val thumbPlayUrl: String? = null,
    val title: String,
    val titlePgc: String,
    val type: String,
    val videoPosterBean: VideoPosterBean? = null,
    val webUrl: WebUrlX
)

data class Author(
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class Consumption(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)

data class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: String,
)

data class Header(
    val actionUrl: String,
    val cover: String,
    val font: String? = null,
    val id: Int,
    val label: Label,
    val labelList: List<Label>,
    val textAlign: String,
)

data class ProviderX(
    val alias: String,
    val icon: String,
    val name: String
)

data class VideoPosterBean(
    val fileSizeStr: String,
    val scale: Double,
    val url: String
)

data class WebUrlX(
    val forWeibo: String,
    val raw: String
)

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class Shield(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
)

data class Label(
    val card: String,
    val text: String? = null
)

data class PlayInfo(
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<Url>,
    val width: Int
)

data class Tag(
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

data class Url(
    val name: String,
    val size: Int,
    val url: String
)