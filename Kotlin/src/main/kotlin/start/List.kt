package start

fun listAdd(): List<String> {
    val list = mutableListOf("1", "2", "3")
    val four = "4"
    list.add(four)
    list.add(four)
    list.add(four)

    return list
}

fun listRemove(): List<String> {
    val list = mutableListOf("a", "b", "c", "d", "d", "d", "d")

    val charD = "d"

    println(list)

    // 只删除最后一个
    list.remove(charD)

    println(list)

    list.removeIf { it == charD }

    println(list)

    return list
}

fun main() {
    println(listAdd())

    println(listRemove())
}