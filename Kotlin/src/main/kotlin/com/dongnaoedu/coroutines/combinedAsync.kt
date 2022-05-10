package com.dongnaoedu.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
   val time = measureTimeMillis {
//       val one = firstJob();
//       val two = secondJob();
//       println("${one + two}")

//       val one = async { firstJob() };
//       val two = async { secondJob() };
//       println("${one.await() + two.await()}")

       val one = async { firstJob() }.await();
       println("$one")
       val two = async { secondJob() }.await();
       println("${ one + two }")
   }
   println("escaped : ${time} ms")
}


suspend fun firstJob():Int {
    delay(1000)
    return 14
}

suspend fun secondJob():Int {
    delay(1000)
    return 25
}