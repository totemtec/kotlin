package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
//    flowDemo()

    flowSwitchThreadDemo()

//    channelFlowDemo()
}

// flow 是 Cold Stream。在没有切换线程的情况下，生产者和消费者是同步非阻塞的
private fun flowDemo() {
    runBlocking {
        val time = measureTimeMillis {
            flow {
                for (i in 1..10) {
                    delay(100)
                    emit(i)
                }
            }.collect {
                delay(100)
                println(it)
            }
        }

        println("cost $time")

    }
}

// flow 切换线程后，跟channelFlow差不多
private fun flowSwitchThreadDemo() = runBlocking {

    val time = measureTimeMillis{
        flow {
            for (i in 1..10) {
                delay(100)
                emit(i)
            }
        }.flowOn(Dispatchers.IO)
            .collect {
                delay(100)
                println(it)
            }
    }

    print("cost $time")
}

//  channel 是 Hot Stream。而 channelFlow 实现了生产者和消费者异步非阻塞模型
private fun channelFlowDemo() {
    runBlocking {
        val time = measureTimeMillis {
            channelFlow {
                for (i in 1..10) {
                    delay(100)
                    send(i)
                }
            }.collect {
                delay(100)
                println(it)
            }
        }

        println("cost $time")
    }
}
