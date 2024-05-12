package start

fun printAll(vararg strings: String) {
    strings.forEach {
        print(it)
        print(" ")
    }
}

fun main() {
    printAll("Hello", "World", "Test")
}