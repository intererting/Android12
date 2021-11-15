package com.example.android12

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import kotlin.coroutines.coroutineContext

/**
 * @author    yiliyang
 * @date      2021/11/3 下午2:05
 * @version   1.0
 * @since     1.0
 */
class LiveDataActivity : AppCompatActivity() {

    private val observer by lazy {
        Observer<Int> { println("reveive  $it") }
    }

    val liveData = liveData(Dispatchers.IO, 1000) {
        println("emit1")
        emit(1)
        emit(2)
        val blockingQueue = LinkedBlockingQueue<String>()
        val value = blockingQueue.poll(5, TimeUnit.SECONDS)
        println("poll $value")
        println(coroutineContext.isActive)
        emit(2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)

        findViewById<Button>(R.id.start).setOnClickListener {
//            liveData.observe(this, observer)
            val liveData = MutableLiveData<String>()
            liveData.postValue("haha")
            liveData.observe(this) {
                println(it)
            }
        }


        findViewById<Button>(R.id.stop).setOnClickListener {
            liveData.removeObserver(observer)
        }
    }
}