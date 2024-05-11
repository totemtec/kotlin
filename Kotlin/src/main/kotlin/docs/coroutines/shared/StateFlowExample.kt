package docs.coroutines.shared

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ViewModel {
    private val _counter = MutableStateFlow(0) // private mutable state flow
    val counter = _counter.asStateFlow() // publicly exposed as read-only state flow

    fun inc() {
        _counter.update { count -> count + 1 } // atomic, safe for concurrent use
    }

    fun reset() {
        _counter.value = 0 // atomic, safe for concurrent use
    }
}

fun main() {
    val viewModel = ViewModel()
    runBlocking {
        val defaultScope = CoroutineScope(Dispatchers.Default)

        defaultScope.launch {
            viewModel.counter.collect {
                println("value is $it")
            }
        }

        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            repeat(1000) {
//                delay(10)
                viewModel.inc()
            }
        }

        val mainScope = CoroutineScope(Dispatchers.Default)
        mainScope.launch {
            repeat(1000) {
//                delay(10)
                viewModel.inc()
            }
        }

        delay(20000) // Keep app alive for a while
    }
}