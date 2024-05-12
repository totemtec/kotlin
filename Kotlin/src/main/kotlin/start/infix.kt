package start

//infix fun Any.to(other: Any) = Pair(this, other)

infix fun String.truncate(target: String) = this.substringBefore(target)

/**
 * 中缀表示法
 */
fun main() {
    println("one" to 1)
    println("two" to 2)

    val map = mapOf(1 to "one", 2 to "two")
    println(map)

    println("Hello Kotlin" truncate " ")
}