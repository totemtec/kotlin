package demo.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * 流的上下文保存，收集流和构建流是同一个上下文
 * 使用flowOn可以切换上下文
 */
fun main() {
//    testFlowContext()

//    testFlowOn()

    testLaunchIn()
}

fun testFlowContext() = runBlocking {
    println("main() run on thread: ${Thread.currentThread().name}")

    val flow = flow<Int> {
        println("flow builder on thread: ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }

    flow.collect {
        println("collect run on thread: ${Thread.currentThread().name}")
        println(it)
    }
}

fun testFlowOn() = runBlocking {
    println("main() run on thread: ${Thread.currentThread().name}")

    val flow = flow<Int> {
        println("flow builder on thread: ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.Default)

    flow.collect {
        println("collect run on thread: ${Thread.currentThread().name}")
        println(it)
    }
}

private fun eventsFlow() = (1..5).asFlow().onEach { delay(1000) }

fun testLaunchIn() = runBlocking {
    println("main() run on thread: ${Thread.currentThread().name}")

    val job = eventsFlow()
        .onEach { println("Event $it ${Thread.currentThread().name}") }
        .launchIn(CoroutineScope(Dispatchers.IO))

    delay(3500)
    job.cancelAndJoin()
}
