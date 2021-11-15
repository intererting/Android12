package com.example.android12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.savedstate.SavedStateRegistry

/**
 *  SavedStateRegistry.SavedStateProvider的使用
 *  1：onSaveInstanceState保存页面条件，比如id等
 *  2：onRestoreInstanceState获取保存的数据，然后到ViewModel中查找，缓存的数据
 *  3：ViewModel没有数据的时候，就去网络查询
 *  4：网络查询失败，从数据库获取
 *  5:如果成功获取到最新数据，然后选择性的保存到数据库或者是ViewModel
 */
class SaveStateActivity : AppCompatActivity(), SavedStateRegistry.SavedStateProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        val registry = savedStateRegistry
        // Register this object for future calls to saveState()
        registry.registerSavedStateProvider("saveState", this)

        // Get the previously saved state and restore it
        val state = registry.consumeRestoredStateForKey("saveState")

        // Apply the previously saved state
        val name = state?.getString("name") ?: "default"
        println(name)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun saveState(): Bundle {
        return bundleOf("name" to "yuliyang")
    }
}