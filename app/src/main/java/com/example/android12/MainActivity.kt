package com.example.android12

import android.content.*
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.Trace
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //1.3版本的activity-ktx这个方法没有，待调查
    private val viewModel by viewModels<SavedStateViewModel>()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        println(resources)
//        println(applicationContext.resources)

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                println(context)
            }
        }, IntentFilter("com.broadcast.test"))

//        lifecycleScope.launchWhenResumed { }

//        val rects = window.decorView.systemGestureExclusionRects

//        findViewById<View>(R.id.myView).viewTreeObserver.addOnDrawListener {
//            println("addOnDrawListener")
//        }
//
//        findViewById<View>(R.id.myView).viewTreeObserver.addOnPreDrawListener {
//            println("addOnPreDrawListener")
//            return@addOnPreDrawListener true
//        }


//        val intent = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult()
//        ) {
//
//        }
        findViewById<Button>(R.id.start).setOnClickListener {
//            viewModel.setQuery("yuliyang")
//            intent.launch(Intent(this, SecondActivity::class.java))
            /*   val liveData = liveData<String>(Dispatchers.Default) {
   //                println(coroutineContext.isActive)
                   println(Thread.currentThread())
               }

               liveData.observeForever {
                   println(it)
               }*/

//            val sendIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
//                type = "text/plain"
//                putExtra(Intent.EXTRA_CHOOSER_TARGETS, myChooserTargetArray)
//            }
//
//            val shareIntent = Intent.createChooser(sendIntent, null)
//            startActivity(shareIntent)


        }

        findViewById<Button>(R.id.startSecondActivity).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<View>(R.id.myView).setOnClickListener {
            println("onClickListener")
        }

    }
}