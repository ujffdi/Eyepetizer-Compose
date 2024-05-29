package com.tongsr.eyepetizer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.tongsr.eyepetizer.business.found.FoundScreen
import com.tongsr.eyepetizer.business.HomeScreen
import com.tongsr.eyepetizer.business.MineScreen
import com.tongsr.eyepetizer.business.SquareScreen
import com.tongsr.eyepetizer.ui.theme.EyepetizerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EyepetizerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }

    @Composable
    private fun Content() {
        TabNavigator(HomeScreen, tabDisposable = {
            TabDisposable(
                navigator = it, tabs = listOf(HomeScreen, SquareScreen, FoundScreen, MineScreen)
            )
        }) { _ ->
            Scaffold(bottomBar = {
                BottomNavigation(Modifier.height(55.dp)) {
                    TabNavigationItem(HomeScreen)
                    TabNavigationItem(SquareScreen)
                    Image(
                        painter = painterResource(R.drawable.ic_tab_publish),
                        contentDescription = "publish",
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxHeight()
                            .clickable {
                                Toast
                                    .makeText(this@MainActivity, "publish", Toast.LENGTH_SHORT)
                                    .show()
                            },
                    )
                    TabNavigationItem(FoundScreen)
                    TabNavigationItem(MineScreen)
                }
            }, content = { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    CurrentTab()
                }
            })
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current

        BottomNavigationItem(
            selected = tabNavigator.current.key == tab.key,
            onClick = { tabNavigator.current = tab },
            icon = { Image(painter = tab.options.icon!!, contentDescription = tab.options.title) },
            modifier = Modifier.background(Color.White)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        EyepetizerTheme {
            Content()
        }
    }

}
