package docs.coroutines.shared

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val state = MutableStateFlow<Int>(0)

    launch {
        delay(1500)

        state.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    launch {
        state.collect { value ->
            println("Collector 2 received: $value")
        }
    }

    launch {
        repeat(3) { i ->
            delay(1000)
            state.emit(i)
        }
    }
}