package com.example.android12

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * @author    yiliyang
 * @date      21-2-24 上午9:55
 * @version   1.0
 * @since     1.0
 */
class SecondActivity : AppCompatActivity() {

    private val myConnection by lazy {
        object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                println("onServiceConnected")
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                println("onServiceDisconnected")
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        Settings.System.getString(contentResolver, Settings.Secure.ANDROID_ID)

        findViewById<Button>(R.id.bind).setOnClickListener {
//            finishActivity(1)
//            bindService(
//                Intent(this, BindService::class.java),
//                myConnection,
//                Context.BIND_AUTO_CREATE
//            )
        }
        findViewById<Button>(R.id.unbind).setOnClickListener {
//            finishActivity(1)
            unbindService(
                myConnection
            )
        }
    }
}