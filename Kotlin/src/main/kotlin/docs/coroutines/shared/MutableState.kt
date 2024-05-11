package docs.coroutines.shared

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(): Unit = runBlocking {
    launch { Flows.evens().collect { println("even: $it") } }
    launch { Flows.evens().collect { println("even2: $it") } }
    launch { Flows.odds().collect { println("odd: $it") } }
}

object Flows {
    private val mutableSharedFlow = MutableSharedFlow<Int>()
    private val shared = mutableSharedFlow.asSharedFlow()
    init {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            for (i in 0..1000) {
                println("writing $i-----------")
                mutableSharedFlow.emit(i)
                delay(100) // To simulate device polling period.
            }
        }
        println("initialized")
    }

    fun evens() = shared.filter { it % 2 == 0 }
    fun odds() = shared.filter { it % 2 == 1 }
}