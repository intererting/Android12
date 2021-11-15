package com.example.android12.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android12.R

/**
 * @author    yiliyang
 * @date      21-2-24 下午2:11
 * @version   1.0
 * @since     1.0
 */
class FragmentCommActivity : AppCompatActivity(R.layout.activity_fragment_comm) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, FragmentA())
        }.commit()
//        findViewById<Button>(R.id.changeFragment).setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                add(R.id.container, FragmentB())
//            }.commit()
//        }

        findViewById<Button>(R.id.changeFragment).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, FragmentB())
                addToBackStack("replaceA")
            }.commit()
        }
    }

    override fun onStop() {
        super.onStop()
        println("activity onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("activity onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        println("activity onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        println("activity onStart")
    }

    override fun onResume() {
        super.onResume()
        println("activity onResume")
    }
}