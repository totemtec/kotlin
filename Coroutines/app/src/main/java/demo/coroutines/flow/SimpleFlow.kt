package demo.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 需求：异步多次返回多个值
 */
fun main() {
//    val list = simpleList()
//
//    list.forEach {
//        println(it)
//    }
//
//    val seq = simpleSequence()
//    seq.forEach {
//        println(it)
//    }
//
//    runBlocking {
//        println("start")
//        val list = delayList()
//        list.forEach {
//            println(it)
//        }
//    }

    runBlocking {
        launch {
            for (i in 1..4) {
                println("I'm not blocked. $i")
                delay(1300)
            }
        }
        simpleFlow().collect {
            println(it)
        }
    }
}

//同步
fun simpleList() = listOf(1, 2, 3)

//异步，但是阻塞
fun simpleSequence() = sequence {
    for (i in 1..3) {
        Thread.sleep(1000)  //阻塞，假装在阻塞
        //sleep(1000) 挂起函数只能在协程里使用
        yield(i)
    }
}

//异步，一次性返回
suspend fun delayList():List<Int> {
    delay(3000)
    return listOf(1, 2, 3)
}

//异步，多次返回多个值
fun simpleFlow() = flow<Int> {
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}