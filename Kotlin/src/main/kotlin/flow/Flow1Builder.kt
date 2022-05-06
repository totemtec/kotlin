package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * flow builder 用来创建 flow
 */
fun main() {
    flowDemo()

    flowOfDemo()

    asFlowDemo()

    channelFlowDemo()
}


private fun flowDemo() {
    runBlocking {
        flow {
            for (i in 1 ..10) {
                delay(100)
                emit(i)
            }
        }.collect {
            println(it)
        }
    }
}

private fun flowOfDemo() {
    runBlocking {
        flowOf(1, 2, 3, 4, 5)
            .onEach {
                delay(100)
            }.collect {
                println(it)
            }
    }
}


private fun asFlowDemo() {
    runBlocking {
        listOf(1, 2, 3, 4, 5).asFlow()
            .onEach {
                delay(100)
            }.collect {
                println(it)
            }
    }
}


private fun channelFlowDemo() {
    runBlocking {
        channelFlow {
            for(i in 1..5) {
                delay(100)
                send(i)
            }
        }.collect() {
            println(it)
        }
    }
}