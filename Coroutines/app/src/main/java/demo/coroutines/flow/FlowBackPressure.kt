package demo.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * 流的背压
 */
fun main() {

//    testFlowBuffer()

//    testFlowDispatch()

//    testFlowConflate()

    testCollectLatest()
}

fun newFlow() = flow<Int> {
    for (i in 1..5) {
        delay(100)
        emit(i)
        println("emitting $i ${Thread.currentThread().name}")
    }
}

fun testFlowBuffer() = runBlocking {
    val time = measureTimeMillis {
        newFlow().buffer(50).collect {
            delay(300)
            println("collect $it ${Thread.currentThread().name}")
        }
    }
    println("time = $time")
}

fun testFlowDispatch() = runBlocking {
    val time = measureTimeMillis {
        newFlow()
            .flowOn(Dispatchers.Default)
//            .buffer(50)
            .collect {
                delay(300)
                println("collect $it ${Thread.currentThread().name}")
            }
    }
    println("time = $time")
}

fun testFlowConflate() = runBlocking {
    val time = measureTimeMillis {
        newFlow()
//            .flowOn(Dispatchers.Default)
//            .buffer(50)
            .conflate()  //合并，不一定处理每一项
            .collect {
                delay(200)
                println("collect $it ${Thread.currentThread().name}")
            }
    }
    println("time = $time")
}

fun testCollectLatest() = runBlocking {
    val time = measureTimeMillis {
        newFlow()
//            .flowOn(Dispatchers.Default)
//            .buffer(50)
//            .conflate()
            .collectLatest {  //只处理最后一个值
                delay(200)
                println("collect $it ${Thread.currentThread().name}")
            }
    }
    println("time = $time")
}
