package com.tongsr.eyepetizer.weiget

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.opensource.svgaplayer.SVGAImageView
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGAVideoEntity

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/25
 * @email ujffdtfivkg@gmail.com
 * @description
 */

@Composable
fun SVGAByAssets(modifier: Modifier = Modifier, assetsName: String) {
    Box(modifier = modifier.fillMaxSize()) {
        AndroidView(factory = { context ->
            SVGAImageView(context).apply {
                val parser = SVGAParser.shareParser()
                parser.decodeFromAssets(assetsName, object : SVGAParser.ParseCompletion {
                    override fun onComplete(videoItem: SVGAVideoEntity) {
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