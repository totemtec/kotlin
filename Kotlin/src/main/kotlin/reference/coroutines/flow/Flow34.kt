package reference.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private fun simple(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    simple()
        .onCompletion { cause -> println("Flow completed with $cause") }
        .collect { value ->
//            check(value <= 1) { "Collected $value" }
            println(value)
        }
}