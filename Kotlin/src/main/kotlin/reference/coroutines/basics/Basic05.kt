package reference.coroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//外部协程（示例中的 runBlocking）直到在其作用域中启动的所有协程都执行完毕后才会结束

fun main() = runBlocking<Unit> {

    //在runBlocking作用域内启动一个协程
    launch {
        delay(1000)
        println("World!")
    }
    println("Hello,")
}