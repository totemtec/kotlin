package reference.coroutines.context

import kotlinx.coroutines.*

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

// 使用 -Dkotlinx.coroutines.debug JVM 参数运行下面的代码：

fun main() = runBlocking<Unit> {
    val a = async {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async {
        log("I'm computing another piece of the answer")
        7
    }
    log("The answer is ${a.await() * b.await()}")
}