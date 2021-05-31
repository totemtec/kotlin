package reference.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private fun simple(): Flow<Int> = flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i)
        }
    }

fun main() = runBlocking<Unit> {
    simple()
        .catch { e -> println("Caught $e") } //不会捕获下游异常
        .collect { value ->
            check(value<=1) { "Collected $value" }
            println(value)
        }
}