package reference.coroutines.basics

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
    GlobalScope.launch {  //启动一个新协程
        delay(1000)
        println("World!")
    }

    println("Hello,") //主线程中的代码会立即执行

    runBlocking { //这里阻塞了主线程
        delay(2000)
    }
}