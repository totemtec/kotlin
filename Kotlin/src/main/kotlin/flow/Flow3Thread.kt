package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    flowSwitchThreadDemo()
}

/**
 * flow切换线程
 * 不要使用 withContext() 来切换 flow 的线程。
 */
private fun flowSwitchThreadDemo() {
    runBlocking {
        flow {
            for (i in 1..10) {
                delay(100)
                emit(i)
            }
        }.map {
            it * it
        }.flowOn(Dispatchers.IO)
            .collect {
                delay(100)
                println("${Thread.currentThread().name}: $it")
            }
    }
}