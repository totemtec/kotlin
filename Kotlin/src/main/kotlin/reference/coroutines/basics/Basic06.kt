package reference.coroutines.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch {
        delay(200)
        println("Task from runBlocking")
    }

    coroutineScope { // 创建一个协程作用域
        launch {
            delay(500)
            println("内嵌launch")
        }

        delay(100)
        println("Task from coroutineScope") // 这一行会在内嵌 launch 之前输出
    }

    println("coroutineScope is over") // 这一行在内嵌 launch 执行完毕后才输出
}