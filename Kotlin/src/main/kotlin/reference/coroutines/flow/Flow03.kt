package reference.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private suspend fun simple(): List<Int> {
    delay(1000) // 假装我们在这里做了一些异步的事情
    return listOf(1, 2, 3)
}

fun main() = runBlocking<Unit> {
    simple().forEach { value -> println(value) }
}