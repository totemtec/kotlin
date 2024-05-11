package docs.coroutines.flow

/**
 * Sequence 也能返回多个值，但是一旦运行较慢，会阻塞线程
 */
fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() {
    simple().forEach { value -> println(value) }
}