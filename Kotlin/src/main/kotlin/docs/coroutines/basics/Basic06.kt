package docs.coroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 这个例子想说明 Coroutine 比 Thread 更轻量。其实 Thread 用上线程池也还可以
 */
fun main() = runBlocking {
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}