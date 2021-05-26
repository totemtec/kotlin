package reference.coroutines.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i")
            delay(500)
        }
    }
    delay(1300)
    println("main: I'm tired of waiting!")
    job.cancel() //取消该作业
    job.join() //等待作业执行结束
    println("main: Now I can quit.")
}