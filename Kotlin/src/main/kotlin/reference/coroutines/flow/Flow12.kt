package reference.coroutines.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it % 2 == 0
        }
        .map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }
}