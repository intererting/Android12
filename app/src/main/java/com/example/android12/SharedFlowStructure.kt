package com.example.android12

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author    yiliyang
 * @date      2021/8/19 下午1:59
 * @version   1.0
 * @since     1.0
 */
fun main() = runBlocking {
//    val sharedFlow = MutableSharedFlow<Int>(replay = 2, extraBufferCapacity = 0)
//    val sharedFlow = MutableSharedFlow<Int>(replay = 1, extraBufferCapacity = 3)
    val sharedFlow = MutableSharedFlow<Int>(replay = 0, extraBufferCapacity = 0)
//    launch {
//        sharedFlow.collect {
//            delay(1000)
//            println("delay 1000  $it")
//        }
//    }
    launch {
        sharedFlow.collect {
            delay(100000000)
            println(it)
        }
    }
    delay(1000)
    sharedFlow.emit(1)
    println("1 success")
    sharedFlow.emit(2)
    println("2 success")
    sharedFlow.emit(3)
    println("3 success")
    sharedFlow.emit(4)
    println("4 success")
    sharedFlow.emit(5)
    println("5 success")
    sharedFlow.emit(6)
    println("6 success")
    sharedFlow.emit(7)
    println("7 success")
//    sharedFlow.resetReplayCache()
//    sharedFlow.collect {
//        delay(1000)
//        println("delay 1000  $it")
//    }
}