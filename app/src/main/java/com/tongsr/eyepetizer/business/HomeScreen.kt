package com.tongsr.eyepetizer.business

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.tongsr.eyepetizer.R
import com.tongsr.eyepetizer.business.home.DailyReportScreen
import com.tongsr.eyepetizer.business.home.FollowScreen
import com.tongsr.eyepetizer.business.home.RecommendedScreen
import kotlinx.coroutines.launch

/**
 * @author Tongsr
 * @date 2024/3/11
 * @description 首页
 */
object HomeScreen : Tab {

    private val tabList = listOf("推荐", "关注", "日报")

    override val options: TabOptions
        @Composable get() {

            val title = stringResource(id = R.string.page_home)

            val tabNavigator = LocalTabNavigator.current
            val icon = painterResource(
                if (tabNavigator.current == this) R.drawable.ic_tab_home_select else R.drawable.ic_tab_home_unselect
            )

            return remember(icon) {
                TabOptions(
                    index = 0u, title = title, icon = icon
                )
            }
        }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val pagerState = rememberPagerState(pageCount = { 3 })

        Column {
            TabRow(selectedTabIndex = pagerState.currentPage,
                divider = {}, // 去除下划线
                indicator = {} // 去除 TabRow 下划线
            ) {
                val coroutineScope = rememberCoroutineScope()
                tabList.forEachIndexed { index, title ->
                    Tab(pagerState.currentPage, index, title) {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
                }
            }

            HorizontalPager(state = pagerState) { page ->
                when(page) {
                    0 -> RecommendedScreen()
                    1 -> FollowScreen()
                    2 -> DailyReportScreen()
                }
            }
        }
    }

    @Composable
    private fun Tab(currentPage: Int, index: Int, title: String, onClickListener: () -> Unit) {
        Box(
            Modifier
                .height(50.dp)
                .background(Color.White)
                .clickable {
                    onClickListener.invoke()
                },
            contentAlignment = Alignment.Center // 将子元素居中对齐
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentPage == index) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_nav_indicator),
                        contentDescription = "",
                        modifier = Modifier.size(15.dp, 15.dp),
                    )
                }
                Text(
                    text = title,
                    modifier = Modifier.padding(start = if (currentPage == index) 8.dp else 0.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            }
        }
    }

}

