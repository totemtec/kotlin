package reference.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow().onEach { delay(300) } // 发射数字 1..3，间隔300毫秒
    val strs = flowOf("one", "two", "three").onEach { delay(400) } //每400毫秒发射一次字符串
    val startTime = System.currentTimeMillis()
    nums.combine(strs) {a, b -> "$a -> $b"}
        .collect {
            value ->
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}