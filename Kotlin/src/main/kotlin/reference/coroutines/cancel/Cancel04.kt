package reference.coroutines.cancel

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i")
                delay(500)
            }
        } finally {
            println("job: I'm running finally.")
        }

    }
    delay(1300)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}