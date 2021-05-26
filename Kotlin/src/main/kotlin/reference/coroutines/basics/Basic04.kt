package reference.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = GlobalScope.launch {
        delay(1000)
        println("World!")
    }
    println("Hello,")
    job.join()  //等待，直到子协程结束
}