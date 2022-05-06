import demo.log
import kotlinx.coroutines.*

// coroutineScope 不切线程，挂起函数，不阻塞当前线程，需要等待内部所有协程都运行完毕

fun main() = runBlocking {
    launch {
        delay(100)
        log("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(500)
            log("Task from nested launch")
        }
        delay(50)
        log("Task from coroutine scope")
    }

    log("Coroutine scope is over")
}