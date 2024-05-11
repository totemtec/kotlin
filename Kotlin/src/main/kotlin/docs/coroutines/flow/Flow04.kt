package docs.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking


/**
 * Flow Builder
 */

fun main() = runBlocking() {
    // Convert an integer range to a flow
    (1..3).asFlow().collect { value -> println(value) }

    flowOf(5, 6, 7).collect { value -> println(value) }

}