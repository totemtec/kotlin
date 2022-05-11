package demo.coroutines.flow

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 流构建器
 */
fun main() = runBlocking {
//    flowOf("One", "Two", "Three")
//        .onEach {
//            delay(1000)
//        }
//        .collect {
//            println(it)
//        }

    listOf(1, 2, 3).asFlow()
        .collect { println(it) }
}
