package reference.coroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    repeat(100_000) {
        launch {
            delay(5000)
            print(".")
        }
    }
}