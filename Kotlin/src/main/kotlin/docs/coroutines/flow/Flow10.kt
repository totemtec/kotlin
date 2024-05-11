package docs.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * 流总是在收集器的 Context 里运行，所以打印能看到线程名为 main
 */
fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simple10(): Flow<Int> = flow {
    log("Started simple flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    simple10().collect {
        value -> log("Collected $value") // 运行在指定上下文中
    }

    /**
     * withContext 可以改变上下文
     */
    withContext(Dispatchers.Default) {
        simple10().collect { value -> log("Collected $value") }
    }

    withContext(Dispatchers.Default) {
        simpleEmitFromDiffContext().collect { value -> log("Collected $value") }
    }
}

/**
 * 长时间运行的消耗 CPU 的代码也许需要在 Dispatchers.Default 上下文中执行，
 * 并且更新 UI 的代码也许需要在 Dispatchers.Main 中执行。
 * 通常，withContext 用于在 Kotlin 协程中改变代码的上下文，
 * 但是 flow {...} 构建器中的代码必须遵循上下文保存属性，并且不允许从其他上下文中发射（emit）。
 */

fun simpleEmitFromDiffContext(): Flow<Int> = flow {
    // 在流构建器中更改消耗 CPU 代码的上下文的错误方式
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100) // 假装我们以消耗 CPU 的方式进行计算
            emit(i) // 发射下一个值，不允许从其他上下文中发射
        }
    }
}