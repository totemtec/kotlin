package docs.coroutines.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld4()
    println("Done")
}

/**
 * 协程里并发执行多个协程
 */
// Concurrently executes both sections
suspend fun doWorld4() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}