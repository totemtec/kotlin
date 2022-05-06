package demo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// runBlocking 不切线程，阻塞当前线程，内部协程又是非阻塞的

fun main() {
    log("start")

    runBlocking {
        launch {
            repeat(3) {
                delay(100)
                log("AAA - $it")
            }
        }

        launch {
            repeat(3) {
                delay(100)
                log("BBB - $it")
            }
        }

        GlobalScope.launch {
            repeat(3) {
                delay(120)
                log("CCC - $it")
            }
        }
    }

    log("end")
    Thread.sleep(2000)
}
