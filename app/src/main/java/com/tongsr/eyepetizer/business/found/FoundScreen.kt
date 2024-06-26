package com.tongsr.eyepetizer.business.found

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
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