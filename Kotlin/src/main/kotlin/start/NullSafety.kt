package start

fun lengthString(str: String?): Int? = str?.length

fun main() {
    println(lengthString("test"))

    println(lengthString(null))

    // Elvis

    var str: String? = null
    println(str?.length ?: 0)
}