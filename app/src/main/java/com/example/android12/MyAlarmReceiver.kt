package com.example.android12

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * @author    yiliyang
 * @date      21-2-26 下午3:09
 * @version   1.0
 * @since     1.0
 */
class MyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //关机后重启会失效，所以必须在开机后重新启动
        println("MyAlarmReceiver onReceive")
    }
}