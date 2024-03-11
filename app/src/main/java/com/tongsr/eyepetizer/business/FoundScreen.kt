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
 * @description 发现
 */
object FoundScreen : Tab {

    override val options: TabOptions
        @Composable get() {

            val title = stringResource(id = R.string.found)

            val tabNavigator = LocalTabNavigator.current
            val icon = painterResource(
                id = if (tabNavigator.current == this)
                    R.drawable.ic_tab_found_select else R.drawable.ic_tab_found_unselect
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
        Text(text = "发现")
    }

}