package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() {
    flowCancel()
}

/**
 * flow 取消
 * 不要使用 withContext() 来切换 flow 的线程。
 */
private fun flowCancel() {
    runBlocking {
        withTimeout(2500) {
            flow {
                for (i in 1..5) {
                    delay(1000)
                    emit(i)
                }
            }.collect {
                println(it)
            }
        }

        println("Done")
    }
}