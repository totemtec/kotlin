package start

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
}

fun main() {
    val reader = BufferedReader(StringReader("Not a number"))
    println(readNumber(reader))
}