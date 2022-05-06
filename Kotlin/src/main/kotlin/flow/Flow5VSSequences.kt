package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//    flowNotBlocked()

    sequenceBlocked()
}

private fun flowNotBlocked() {
    runBlocking {
        launch {
            for (j in 1..5) {
                delay(100)
                println("I'm not blocked $j")
            }
        }

        flow {
            for (i in 1..5) {
                delay(100)
                emit(i)
            }
        }.collect {
            println(it)
        }

        println("Done")
    }
}


private fun sequenceBlocked() {
    runBlocking {
        launch {
            for (j in 1..5) {
                delay(100)
                println("I'm not blocked $j")
            }
        }

        sequence {
            for (i in 1..5) {
                Thread.sleep(100)
                yield(i)
            }
        }.forEach {
            println(it)
        }

        println("Done")
    }
}