package reference.coroutines.cancel

import kotlinx.coroutines.*

var acquired = 0

class Resource {
    init { acquired++ }
    fun close() { acquired-- }
}

fun main() = runBlocking<Unit> {
    repeat(100_000) {
        launch {
            val resource = withTimeout(60) {
                delay(50)
                Resource()
            }
            resource.close()
        }
    }

    println(acquired)
}