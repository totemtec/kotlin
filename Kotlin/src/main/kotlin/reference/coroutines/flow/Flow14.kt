package reference.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 通常，withContext 用于在 Kotlin 协程中改变代码的上下文
 * 但是 flow {...} 构建器中的代码必须遵循上下文保存属性，并且不允许从其他上下文中发射（emit）。
 */
private fun simple(): Flow<Int> = flow {

    // 在流构建器中更改消耗 CPU 代码的上下文的错误方式
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100)
            emit(i)
        }
    }

}

fun main() = runBlocking<Unit> {
    simple().collect { value -> log("Collected $value") }
}