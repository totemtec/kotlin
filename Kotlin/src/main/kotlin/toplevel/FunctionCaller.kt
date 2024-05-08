package toplevel

import toplevel.joinToString

fun main() {
    val list = listOf("A", "B", "C")
    val result = joinToString(list)
    println(result)
}