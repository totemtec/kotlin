package reference.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    (1..3).asFlow().collect { value -> println(value) }
}