package com.example.android12.coroutine

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author    yiliyang
 * @date      2021/9/9 下午3:24
 * @version   1.0
 * @since     1.0
 */
fun main() = runBlocking {
    //默认0-----SUSPEND 没有消费者会suspend
//    val channel = Channel<String>() {
//        println(it)
//    }

//    0----- BufferOverflow.DROP_OLDEST 只有3 buffer为1
//    val channel = Channel<String>(onBufferOverflow = BufferOverflow.DROP_OLDEST) {
//        println(it)
//    }

//    0----- BufferOverflow.DROP_LATEST 只有1 buffer为1
//    val channel = Channel<String>(onBufferOverflow = BufferOverflow.DROP_LATEST) {
//        println(it)
//    }

    //CONFLATED----- BufferOverflow.SUSPEND 相当于DROP_OLDEST 只有3,不同的是onUndeliveredElement会触发
//    val channel = Channel<String>(capacity = Channel.CONFLATED) {
//        //onUndeliveredElement
//        println(it)
//    }

//    UNLIMITED-----底层采用链表实现，可以无限缓存
//    val channel = Channel<String>(capacity = Channel.UNLIMITED) {
//        //onUndeliveredElement
//        println(it)
//    }

//     BUFFERED-----SUSPEND 默认缓存64，超过suspend
//    val channel = Channel<String>(capacity = Channel.BUFFERED) {
//        //onUndeliveredElement
//        println(it)
//    }

//    BUFFERED-----DROP_LATEST 缓存1,只有1，不会触发onUndeliveredElement
//    val channel = Channel<String>(
//        capacity = Channel.BUFFERED,
//        onBufferOverflow = BufferOverflow.DROP_LATEST
//    ) {
//        //onUndeliveredElement
//        println(it)
//    }

//    BUFFERED-----DROP_OLDEST 缓存1,只有3，不会触发onUndeliveredElement
    val channel = Channel<String>(
        capacity = Channel.BUFFERED,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    ) {
        //onUndeliveredElement
        println(it)
    }
    launch {
        delay(1000)
        channel.consumeEach {
            println("receive $it")
        }
    }
    send_default(channel)
}

suspend fun send_default(channel: Channel<String>) {
    println("offer ${channel.offer("1")}")
    println("offer ${channel.offer("2")}")

//    channel.send("1")
//    println("send 1 success")
//    channel.send("2")
//    println("send 2 success")
//    channel.send("3")
//    println("send 3 success")
}
