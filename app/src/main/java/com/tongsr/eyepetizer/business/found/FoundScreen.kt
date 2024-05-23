package com.tongsr.eyepetizer.business.found

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.opensource.svgaplayer.SVGAImageView
import com.opensource.svgaplayer.SVGAParser
import com.tongsr.eyepetizer.R

/**
 * @author Tongsr
 * @date 2024/3/11
 * @description 发现
 */
object FoundScreen : Tab {
    private fun readResolve(): Any = FoundScreen

    override val options: TabOptions
        @Composable get() {

            val title = stringResource(id = R.string.found)

            val tabNavigator = LocalTabNavigator.current
            val icon = painterResource(
                id = if (tabNavigator.current == this) R.drawable.ic_tab_found_select else R.drawable.ic_tab_found_unselect
            )

            return remember(icon) {
                TabOptions(
                    index = 0u, title = title, icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize()) {
            AndroidView(factory = { context ->
                SVGAImageView(context).apply {
                    val parser = SVGAParser.shareParser()
                    parser.decodeFromAssets("lucky_gift_combo_count_1314.svga",
                        object : SVGAParser.ParseCompletion {
                            override fun onComplete(videoItem: com.opensource.svgaplayer.SVGAVideoEntity) {
                                setVideoItem(videoItem)
                                startAnimation()
                            }

                            override fun onError() {
                            }
                        })
                }
            }, update = {
                Log.e("SVGAImageView", "update")
            }, modifier = Modifier.fillMaxSize()
            )
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Banner(modifier: Modifier = Modifier) {
        val pagerState = rememberPagerState(pageCount = { 3 })
        HorizontalPager(state = pagerState) { page ->

        }
    }

    @Composable
    fun BannerItem(modifier: Modifier = Modifier, url: String) {
        ConstraintLayout {

        }
    }

}