package com.example.android12.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.android12.R

/**
 * @author    yiliyang
 * @date      21-2-24 下午2:10
 * @version   1.0
 * @since     1.0
 */
class FragmentA : Fragment() {

    private val lifecycleObserver by lazy {
        Observer<LifecycleOwner> { t -> println("onChange  ${t?.lifecycle?.currentState}") }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewLifecycleOwnerLiveData.observeForever(lifecycleObserver)
        setFragmentResultListener("data") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getString("name")
            // Do something with the result
            println("result  $result")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("onViewCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onStop() {
        super.onStop()
        println("fragment onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("fragment onSaveInstanceState")
    }

    override fun onStart() {
        super.onStart()
        println("fragment onStart")
    }

    override fun onResume() {
        super.onResume()
        println("fragment onResume")
    }

    override fun onDestroyView() {
        viewLifecycleOwnerLiveData.removeObserver(lifecycleObserver)
        super.onDestroyView()
    }
}