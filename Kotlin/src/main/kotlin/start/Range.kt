package start

fun rangeTest() {
    (1..5).forEach {
        println(it)
    }

    val range  = 'A'..'F'
    range.forEach {
        println(it)
    }

    // range 无法直接打印
    println(range)

    val languages = "Java".."Python"
    println("Kotlin" in languages)  // true
    println(languages)
}

fun main() {
    rangeTest()
}