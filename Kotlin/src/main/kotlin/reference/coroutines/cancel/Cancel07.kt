package reference.coroutines.cancel

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }

        "Done"
    }

    println("Result is $result")
}