package demo.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 冷流：直到末端操作符收集的时候才运行
 */
fun main() {

//    runBlocking {
//        val flow = coldFlow()
//        println("Collect start.")
//        flow.collect { println(it) }
//        println("Collect again.")
//        flow.collect { println(it) }
//    }

    runBlocking {
        val flow = coldFlow() //(1..5).asFlow()

        flow.filter {
            it % 2 == 1
        }.map {
            "value is $it"
        }.collect {
            println(it)
        }
    }
}

fun coldFlow() = flow<Int> {
    println("Flow start.")
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}
