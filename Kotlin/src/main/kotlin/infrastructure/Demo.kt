package infrastructure

import kotlin.coroutines.*

fun main() {
    val coroutine = suspend {
        5
    }.createCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine End: ${result}")
        }
    })

    coroutine.resume(Unit)
}