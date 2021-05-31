package reference.coroutines.context

import kotlinx.coroutines.*


fun main() = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")
}