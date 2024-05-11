package docs.coroutines.flow

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * flowOn
 * 这里要观察的另一件事是 flowOn 操作符已改变流的默认顺序性。
 * 现在收集发生在一个协程中（“coroutine#1”）而发射发生在运行于另一个线程中与收集协程并发运行的另一个协程（“coroutine#2”）中。
 * 当上游流必须改变其上下文中的 CoroutineDispatcher 的时候，flowOn 操作符创建了另一个协程。
 */

fun printLog(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simple11(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100) // 假装我们以消耗 CPU 的方式进行计算
        printLog("Emitting $i")
        emit(i) // 发射下一个值
    }
}.flowOn(Dispatchers.Default) // 在流构建器中改变消耗 CPU 代码上下文的正确方式

fun main() = runBlocking<Unit> {
    simple11().collect { value ->
        printLog("Collected $value")
    }
}