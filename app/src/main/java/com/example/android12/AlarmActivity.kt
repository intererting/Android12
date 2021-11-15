package com.example.android12

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Interpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * @author    yiliyang
 * @date      21-2-26 下午3:06
 * @version   1.0
 * @since     1.0
 */
class AlarmActivity : AppCompatActivity() {

    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_alarm)
        alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(this, MyAlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(this, 0, intent, 0)
        }

        findViewById<Button>(R.id.start).setOnClickListener {
            println("start Alarm")
            alarmMgr?.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 5000,
                1000 * 60,
                alarmIntent
            )
        }
    }
}