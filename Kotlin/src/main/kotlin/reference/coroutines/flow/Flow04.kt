package reference.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun simple(): Flow<Int> = flow {
    for(i in 1..3) {
        delay(1000)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    // 此协程和 flow 协程互不影响
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(1600)
        }
    }

    simple().collect { value -> println(value) }
}