package com.example.android12

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

/**
 * @author    yiliyang
 * @date      2021/8/30 上午9:12
 * @version   1.0
 * @since     1.0
 */
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            println(it.data)
        }
    }
}