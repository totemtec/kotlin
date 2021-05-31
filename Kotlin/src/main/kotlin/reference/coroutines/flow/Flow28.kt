package reference.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private fun simple(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i)
        }
    }.map { value ->
        check(value <= 1) { "Crashed on $value" }
        "string $value"
    }

fun main() = runBlocking<Unit> {
    simple()
        .catch { e -> emit("Caught $e") }
        .collect { value -> println(value) }
}