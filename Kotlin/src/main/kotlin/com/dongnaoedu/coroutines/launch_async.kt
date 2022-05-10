package com.dongnaoedu.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    testLaunchAsync()
}

fun testLaunchAsync() =  runBlocking {
    val launchJob = launch {
        delay(200)
        println("launchJob finish")
    }

    // async 返回 Deferred<T>: 继承自Job，可以带返回结果的
    val asyncJob = async {
        delay(200)
        println("asyncJob finish")
        "asyncJob result"
    }

    println("start")
    println(asyncJob.await())
}

fun testJoin() = runBlocking {

    println("start")

    val job1 = launch {
        delay(3000)
        println("job1 finish")
    }

    job1.join()

    val job2 = launch {
        delay(2000)
        println("job2 finish")
    }

    val job3 = launch {
        delay(1000)
        println("job3 finish")
    }
}

fun testAwait() = runBlocking {

    println("start")

    val job1 = async {
        delay(3000)
        println("job1 finish")
    }

    job1.await()

    val job2 = async {
        delay(2000)
        println("job2 finish")
    }

    val job3 = async {
        delay(1000)
        println("job3 finish")
    }
}