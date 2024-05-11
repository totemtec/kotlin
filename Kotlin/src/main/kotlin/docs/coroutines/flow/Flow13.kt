package docs.coroutines.flow

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

fun simple13(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        emit(i) // 发射下一个值
    }
}

/**
 * conflate() 不处理每一个值，只处理最新的，如果末端速度跟不上，会丢弃一些数值
 */

fun main() = runBlocking<Unit> {

    val time = measureTimeMillis {
        simple13()
            .conflate() // 合并发射项，不对每个值进行处理
            .collect { value ->
                delay(300) // 假装我们花费 300 毫秒来处理它
                println(value)
            }
    }
    println("Collected in $time ms")
}