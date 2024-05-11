package docs.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * transform 类似 map 和 filter，但是能做更多复杂的转换，可以多次 emit
  */
suspend fun performRequest2(request: Int): String {
    delay(1000) // 模仿长时间运行的异步工作
    return "response $request"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .transform { request ->
            emit("Making request $request")
            emit(performRequest2(request))
        }
        .collect { response -> println(response) }
}