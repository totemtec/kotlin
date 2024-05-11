package docs.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * suspend 方法只能一次性返回多个值
 */
suspend fun simpleSuspend(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking<Unit> {
    simpleSuspend().forEach { value -> println(value) }
}