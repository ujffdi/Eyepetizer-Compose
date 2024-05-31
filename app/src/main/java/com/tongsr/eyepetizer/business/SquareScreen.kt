package com.tongsr.eyepetizer.business

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.tongsr.eyepetizer.R

/**
 * @author Tongsr
 * @date 2024/3/11
 * @description 广场
 */
object SquareScreen : Tab {

    override val options: TabOptions
        @Composable get() {

            val title = stringResource(id = R.string.square)

            val tabNavigator = LocalTabNavigator.current
            val icon = painterResource(
                if (tabNavigator.current == this) R.drawable.ic_tab_square_select else R.drawable.ic_tab_square_unselect
            )

            return remember(icon) {
                TabOptions(
                    index = 0u, title = title, icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val list = remember {
            mutableStateListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        }
        Column {
            Button(onClick = {
                list[0] = "a"
                list[1] = "b"
                list[2] = "c"
            }) {
                Text(text = "Square Button")
            }
            LazyColumn {
                items(list.size) {
                    ContentTest(text = list[it])
                }
            }
        }
    }

    @Composable
    fun ContentTest(modifier: Modifier = Modifier, text: String) {
        Log.e("tongsr", "触发 ContentTest")
        Text(text = "Square Item $text")
    }

}