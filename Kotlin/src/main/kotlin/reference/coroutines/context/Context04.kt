package reference.coroutines.context

import kotlinx.coroutines.*

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

// 使用 -Dkotlinx.coroutines.debug JVM 参数运行下面的代码：

fun main() = runBlocking<Unit> {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started in ctx1")
                withContext(ctx2) {
                    log("Working in ctx2")
                }
                log("Back to ctx1")
            }
        }
    }
}