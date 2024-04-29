package start

class Rectangle(private val width: Int, private val height: Int) {
    val isSquare: Boolean
        get() {
            return width == height
        }
}

fun main() {
    val rect = Rectangle(42, 42)
    println(rect.isSquare)
}