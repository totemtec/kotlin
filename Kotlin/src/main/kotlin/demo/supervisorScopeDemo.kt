package demo

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main():Unit = runBlocking {
    launch {
        delay(100)
        log("Task from runBlocking")
    }

    supervisorScope {
        launch {
            delay(500)
            log("Task Throw Exception")
            throw Exception("failed")
        }

        launch {
            delay(600)
            log("Task from nested launch")
        }
    }
    log("Coroutine scope is over")
}