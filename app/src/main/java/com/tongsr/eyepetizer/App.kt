package com.tongsr.eyepetizer

import android.app.Application
import com.opensource.svgaplayer.SVGACache
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.utils.log.SVGALogger
import dagger.hilt.android.HiltAndroidApp

/**
 * @author tongsr
 * @version 1.0
 * @date 2024/5/20
 * @email ujffdtfivkg@gmail.com
 * @description
 */
@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        SVGACache.onCreate(this, SVGACache.Type.DEFAULT)
        SVGALogger.setLogEnabled(true)
        SVGAParser.shareParser().init(this)
    }

}