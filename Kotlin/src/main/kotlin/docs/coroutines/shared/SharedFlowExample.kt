package docs.coroutines.shared

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Publisher {
    private val publishingScope = CoroutineScope(SupervisorJob())

    val messagesFlow: SharedFlow<Int> = MutableSharedFlow<Int>(
        replay = 0,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.SUSPEND
    ).also { flow ->
        // emit messages
        publishingScope.launch {
            repeat(100) {
                println("emitting $it")
                flow.emit(it)
                delay(500)
            }
        }
    }
}

fun main() {
    val publisher = Publisher()
    runBlocking {
        val subscribingScope = CoroutineScope(SupervisorJob())

        subscribingScope.launch {
            publisher.messagesFlow.collect { println("subscriber 1 -> $it") }
            // Any code below collection in this inner coroutine won't be reached because collect doesn't complete normally.
        }

        // Delay a while. We'll miss the first couple messages.
        delay(1300)

        // Subscribe to the shared flow
        subscribingScope.launch {
            publisher.messagesFlow.collect { println("I am collecting message $it") }
            // Any code below collection in this inner coroutine won't be reached because collect doesn't complete normally.
        }

        delay(30000) // Keep app alive for a while
    }
}