package docs.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * terminal operator 末端操作符
 * first() 只取第一个
 * collect() 收集
 * toList() 变为List
 * toSet() 变为Set
 * reduce() 归纳，减少
 * fold() 折叠，合拢。带初始值
 */
fun main() = runBlocking {
    val sum = (1..5).asFlow()
        .map { it * it } // squares of numbers from 1 to 5
        .reduce { a, b -> a + b } // sum them (terminal operator)
    println(sum)

    val sum2 = (1..5).asFlow()
        .fold(10) { sum, element -> sum + element }

    println(sum2)
}
