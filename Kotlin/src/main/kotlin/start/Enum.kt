package start

enum class Color ( val r: Int, val g: Int, val b: Int ) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0),
    ;

    fun rgb() = (r * 256 + g) * 256 + b
}


fun main() {
    println(Color.RED.rgb())
    println(Color.GREEN.rgb())
    println(Color.BLUE.rgb())
}
