package demo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch(Dispatchers.IO) {
        delay(1000)
        log("world")
    }

    log("hello")

    Thread.sleep(2000)
}

fun log(message: String) {
    println("[${Thread.currentThread().name}]: ${message}")
}