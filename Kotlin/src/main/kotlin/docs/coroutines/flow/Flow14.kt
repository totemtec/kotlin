package docs.coroutines.flow

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

fun simple14(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        emit(i) // 发射下一个值
    }
}

/**
 * 当发射器和收集器都很慢的时候，conflate() 合并是加快处理速度的一种方式。它通过删除发射值来实现。
 * 另一种方式是取消缓慢的收集器，并在每次发射新值的时候重新启动它。
 * 有一组与 xxx 操作符执行相同基本逻辑的 xxxLatest 操作符，但是在新值产生的时候取消执行其块中的代码。
 * 让我们在先前的 Flow13.kt 中尝试更换 conflate 为 collectLatest：
 */

fun main() = runBlocking<Unit> {

    val time = measureTimeMillis {
        simple14()
            .collectLatest { value -> // 取消并重新发射最后一个值
                println("Collecting $value")
                delay(300) // 假装我们花费 300 毫秒来处理它
                println("Done $value")
            }
    }
    println("Collected in $time ms")

}

// 输出如下：

//Collecting 1
//Collecting 2
//Collecting 3
//Done 3
//Collected in 697 ms

