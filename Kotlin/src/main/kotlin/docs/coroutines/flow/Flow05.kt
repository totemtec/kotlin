package docs.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * 中间操作符，map 和 filter，都是冷流
  */
suspend fun performRequest(request: Int): String {
    delay(1000) // 模仿长时间运行的异步工作
    return "response $request"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow() // 一个请求流
        .map { request -> performRequest(request) }
        .collect { response -> println(response) }
}