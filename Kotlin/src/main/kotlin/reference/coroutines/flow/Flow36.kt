package reference.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// 模仿事件流
private fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(1000) }

fun main() = runBlocking<Unit> {
    println("Start")
    events()
        .onEach { event -> println("Event: $event") }
        .launchIn(this) // <--- 在单独的协程中执行流
    println("Done")
}