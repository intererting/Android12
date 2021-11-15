package com.example.android12

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.MotionEventCompat

/**
 * @author    yiliyang
 * @date      21-2-25 下午4:19
 * @version   1.0
 * @since     1.0
 */
class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var detector: GestureDetectorCompat

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        println("onSizeChanged $w  $h")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        println(MeasureSpec.getSize(widthMeasureSpec))
        super.onMeasure(
            widthMeasureSpec,
            heightMeasureSpec
        )
//        setMeasuredDimension(100, 100)
    }

    init {
        detector = GestureDetectorCompat(context, object :
            GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent): Boolean {
                println("onDown")
                return true
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                println("onSingleTapUp")
                return true
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
//        detector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        println("onDraw")
    }
}