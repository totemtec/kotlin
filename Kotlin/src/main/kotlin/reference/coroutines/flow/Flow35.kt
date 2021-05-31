package reference.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// 模仿事件流
private fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(1000) }

fun main() = runBlocking<Unit> {
    println("Start")
    events()
        .onEach { event -> println("Event: $event") }
        .collect() // <--- 等待流收集
    println("Done")
}