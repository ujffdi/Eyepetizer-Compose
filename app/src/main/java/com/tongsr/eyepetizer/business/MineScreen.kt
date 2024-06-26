package com.tongsr.eyepetizer.business

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.tongsr.eyepetizer.R

/**
 * @author Tongsr
 * @date 2024/3/11
 * @description 我的
 */
object MineScreen : Tab {
    private fun readResolve(): Any = MineScreen

    override val options: TabOptions
        @Composable get() {

            val title = stringResource(id = R.string.mine)

            val tabNavigator = LocalTabNavigator.current
            val icon = painterResource(
                if (tabNavigator.current == this)
                    R.drawable.ic_tab_mine_select else R.drawable.ic_tab_mine_unselect
            )

            return remember(icon) {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable override fun Content() {
        Text(text = "我的")
    }

}