package docs.coroutines.flow

import kotlinx.coroutines.runBlocking


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * Buffer，emit快，collect慢，发射端会等待末端
 */

fun simple12(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 100 ms
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple12().collect { value ->
            delay(300) // pretend we are processing it for 300 ms
            println(value)
        }
    }
    println("Collected in $time ms")

    val time2 = measureTimeMillis {
        simple12()
            .buffer()   // buffer以后，emit端再也不用等待 collect端
            .collect { value ->
            delay(300) // pretend we are processing it for 300 ms
            println(value)
        }
    }
    println("Collected2 in $time2 ms")
}