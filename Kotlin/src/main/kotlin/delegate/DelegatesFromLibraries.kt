package delegate

import kotlin.properties.Delegates

/**
 * lazy
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

/**
 * observable
 */
class User {
    var name by Delegates.observable("<no name>") {
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

fun main() {
    println(lazyValue)
    println(lazyValue)

    val user = User()
    user.name = "Ma"
    user.name = "Totem"
}