package reference.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow()
    val strs = flowOf("one", "two", "three")
    nums.zip(strs) {a, b -> "$a -> $b"}
        .collect { println(it) }
}