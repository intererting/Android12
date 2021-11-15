package com.example.android12.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.android12.R

/**
 * @author    yiliyang
 * @date      21-2-24 下午2:10
 * @version   1.0
 * @since     1.0
 */
class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<Button>(R.id.setResult).setOnClickListener {
            setFragmentResult("data", bundleOf("name" to "yuliyang"))
        }
    }
}