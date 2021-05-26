package reference.coroutines.context

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined: I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default: I'm working in thread ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("MyOwnTHread")) {
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    }
}