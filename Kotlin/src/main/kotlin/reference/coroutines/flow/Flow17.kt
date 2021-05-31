package reference.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple()
            .buffer()
            .collect { value ->
                delay(300)
                log("Collected $value")
            }
    }

    println("Collected in $time ms")
}