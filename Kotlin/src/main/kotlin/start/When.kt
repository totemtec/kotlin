package start

fun whenUseEnum(color: Color) {
    when(color) {
        Color.RED -> println("Red")
        Color.GREEN -> println("Green")
        Color.BLUE -> println("Blue")
        else -> println("Others")
    }
}

fun whenUseObject(c1: Color, c2: Color) {
    when(setOf(c1, c2)) {
        setOf(Color.RED, Color.GREEN) -> println("Red and Green")
        setOf(Color.GREEN, Color.BLUE) -> println("Green and Blue")
        setOf(Color.BLUE, Color.RED) -> println("Blue and Red")
        else -> println("Others")
    }
}

fun main() {
    whenUseEnum(Color.RED)
    whenUseEnum(Color.GREEN)

    whenUseObject(Color.GREEN, Color.BLUE)
    whenUseObject(Color.GREEN, Color.GREEN)
}