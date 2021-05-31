package reference.coroutines.context

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething() // 运行测试函数
    println("Launched coroutines")
    delay(500L) // 延迟半秒钟
    println("Destroying activity!")
    activity.destroy() // 取消所有的协程
    delay(1000) // 为了在视觉上确认它们没有工作
}