package com.example.android12

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View


/**
 * @author    yiliyang
 * @date      2021/9/7 上午10:20
 * @version   1.0
 * @since     1.0
 */
class EdgeEffectActivity : AppCompatActivity(R.layout.activity_edge_effect) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.actionMasked != MotionEvent.ACTION_MOVE) {
            val pointerCount = event.pointerCount
            for (i in 0 until pointerCount) {
                Log.d(
                    "EdgeEffectActivity", "pointerid is " +
                            event.getPointerId(i) +
                            " pointerIndex is " + i
                )
            }
        }
        return super.onTouchEvent(event)
    }
}