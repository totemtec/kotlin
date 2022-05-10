package com.dongnaoedu.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    println("begin")

    runBlocking {
        delay(5000)
        println("runBlocking finish")
    }

    println("end")
}