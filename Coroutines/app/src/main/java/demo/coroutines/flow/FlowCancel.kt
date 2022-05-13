package demo.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.flow.*

/**
 * 流的取消
 */
fun main() {
//    timeoutCancel()

//    cancelCheck()

//    nonCancellable()

    cancellable()
}

fun cancelableFlow() = flow<Int> {
    for (i in 1..3) {
        delay(1000)
        emit(i)
        println("emitting $i")
    }
}

fun timeoutCancel() = runBlocking {
    withTimeoutOrNull(2500) {
        cancelableFlow().collect {
            println(it)
        }
    }
    println("Done")
}

fun cancelCheckFlow() = flow<Int> {
    for (i in 1..5) {
        emit(i)
        println("emitting $i")
    }
}

fun cancelCheck() = runBlocking {
    cancelableFlow().collect {
        println(it)
        if (it == 3) cancel()
    }
}

fun nonCancellable() = runBlocking {
    (1..5).asFlow().collect() {
        println(it)
        if (it == 3) cancel()
    }
}

fun cancellable() = runBlocking {
    (1..5).asFlow().cancellable().collect() {
        println(it)
        if (it == 3) cancel()
    }
}
