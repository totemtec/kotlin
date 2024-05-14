package docs.coroutines.shared

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val sharedFlow = MutableSharedFlow<Int>()

    launch {
        sharedFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    launch {
        sharedFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }

    launch {
        repeat(3) { i ->
            delay(1000)
            sharedFlow.emit(i)
        }
    }
}