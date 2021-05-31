package reference.coroutines.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val sum = (1..5).asFlow()
        .map { it * it }
        .reduce { a, b -> a + b }
    println(sum)
}