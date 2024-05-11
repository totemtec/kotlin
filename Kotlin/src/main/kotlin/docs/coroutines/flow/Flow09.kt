package docs.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * 流是顺序流
 */
fun main() = runBlocking {
    (1..6).asFlow()
        .filter {
            println("Filter $it")
            delay(1000)
            it % 2 == 0
        }
        .map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }
}