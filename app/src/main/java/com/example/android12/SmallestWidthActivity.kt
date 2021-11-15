package com.example.android12

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity

/**
 * @author    yiliyang
 * @date      2021/8/31 下午5:22
 * @version   1.0
 * @since     1.0
 */
class SmallestWidthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smallest_width)
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        println("${metrics.widthPixels}    ${metrics.heightPixels}")
        println("${metrics.densityDpi}    ${metrics.ydpi}")
    }
}