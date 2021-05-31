package reference.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100) // 假装我们以消耗 CPU 的方式进行计算
        log("Emitting $i")
        emit(i) // 发射下一个值
    }
}.flowOn(Dispatchers.Default) //// 在流构建器中改变消耗 CPU 代码上下文的正确方式

fun main() = runBlocking<Unit> {
    simple().collect { value -> log("Collected $value") }
}