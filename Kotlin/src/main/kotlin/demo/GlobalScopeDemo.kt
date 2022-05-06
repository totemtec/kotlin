package demo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// GlobalScope 全局协程作用域，在这个范围内启动的协程可以一直运行直到应用停止运行。日常开发中应该谨慎使用 GlobalScope

fun main() {
    log("start")
    GlobalScope.launch {
        launch {
            delay(400)
            log("AAA")
        }

        launch {
            delay(300)
            log("BBB")
        }

        log("CCC")
    }

    log("end")
    Thread.sleep(2000)
}