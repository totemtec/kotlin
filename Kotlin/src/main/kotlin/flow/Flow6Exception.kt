package flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

fun main() {

//    flowTryCatch()

//    flowOnException()

//    flowCatch()

    flowCatch2()
}

private fun flowTryCatch() {
    runBlocking {
        flow {
            emit(1)
            try {
                throw RuntimeException()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.onCompletion {
            println("Done")
        }.collect {
            println(it)
        }
    }
}

private fun flowOnException() {
    runBlocking {
        flow {
            emit(1)
            throw RuntimeException()
        }.onCompletion { cause: Throwable? ->
            if (cause != null)
                println("Flow completed exceptionally")
            else
                println("Done")
        }.collect {
            println(it)
        }
    }
}

private fun flowCatch() {
    runBlocking {
        flow {
            emit(1)
            throw RuntimeException()
        }.onCompletion { cause: Throwable? ->
            if (cause != null)
                println("Flow completed exceptionally")
            else
                println("Done")
        }
            .catch { println("catch exception") }
            .collect { println(it) }
    }
}

private fun flowCatch2() {
    runBlocking {
        flow {
            emit(1)
            throw RuntimeException()
        }
            .catch { println("catch exception") }
            .onCompletion { cause: Throwable? ->
                if (cause != null)
                    println("Flow completed exceptionally")
                else
                    println("Done")
            }
            .collect { println(it) }
    }
}

