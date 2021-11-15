package com.example.android12.coroutine

import kotlinx.coroutines.*

/**
 * @author    yiliyang
 * @date      2021/8/20 上午9:43
 * @version   1.0
 * @since     1.0
 */
fun main() = runBlocking {
    val job = Job()

    val scope = CoroutineScope(job)
    val jobs = scope.launch {
        println("outer job")
        scope.launch {
            repeat(100) {
                delay(1000)
                println("inner job")
            }
        }
    }
    delay(5000)
    jobs.cancel()
//    job.cancel()
    println("job canceled")
    delay(100000)
    return@runBlocking
}