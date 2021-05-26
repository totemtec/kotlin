package reference.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleep $i")
            delay(500)
        }
    }

    delay(1300)
}