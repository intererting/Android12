package com.example.android12

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.*

/**
 * @author    yiliyang
 * @date      21-2-24 上午10:26
 * @version   1.0
 * @since     1.0
 */
class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val filteredData: LiveData<String> =
//        savedStateHandle.getLiveData<String>("query").switchMap { query ->
////            repository.getFilteredData(query)
//        }

        savedStateHandle.getLiveData("query")

    init {
        filteredData.observeForever {
            println(it)
        }

        //会在onSavedInstanceState中回调
//        savedStateHandle.setSavedStateProvider("tempData") {
//            println("save tempData")
//            bundleOf("name" to "tempData")
//        }
    }

    fun setQuery(query: String) {
//        println(savedStateHandle.get<Bundle>("tempData")?.getString("name"))
        savedStateHandle["query"] = query
    }
}