package docs.coroutines.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * runBlocking 和 coroutineScope 都是 Scope builder
 * runBlocking方法会阻塞当前线程等待。是常规函数
 * coroutineScope只是挂起，释放底层线程以供其他用途。是挂起函数
 */
fun main() = runBlocking {
    doWorld3()
}

suspend fun doWorld3() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}