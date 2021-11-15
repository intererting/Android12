package com.example.android12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

/**
 * @author    yiliyang
 * @date      2021/10/8 下午3:30
 * @version   1.0
 * @since     1.0
 */
class BundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = bundleOf {
            strings["name"] = "yuliyang"
            ints["age"] = 12
        }
        println(bundle["name"])
        println(bundle["age"])
    }
}

inline fun bundleOf(builder: Bundle.() -> Unit) = Bundle().apply(builder)

inline val Bundle.strings get() = BundleString(this)

inline val Bundle.ints get() = BundleInt(this)

@JvmInline
value class BundleString(private val bundle: Bundle) {
    operator fun set(key: String, value: String?) {
        value?.apply {
            bundle.putString(key, value)
        } ?: bundle.remove(key)
    }

    operator fun get(key: String) = bundle.getString(key)
}

@JvmInline
value class BundleInt(private val bundle: Bundle) {
    operator fun set(key: String, value: Int?) {
        value?.apply {
            bundle.putInt(key, value)
        } ?: bundle.remove(key)
    }

    operator fun get(key: String) = bundle.getString(key)
}
