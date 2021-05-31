package reference.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500) // 等待 500 毫秒
    emit("$i: Second")
}

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 记录开始时间
    (1..3).asFlow().onEach { delay(100) } // 每 100 毫秒发射一个数字
        .flatMapLatest { requestFlow(it) }
        .collect { value -> // 收集并打印
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}