package start

data class Person(val name: String?)

fun showName(person: Person) {
    val name = person.name ?: throw IllegalArgumentException("Name required")
    println(name)
}

fun justThrow() {
    throw Exception("Hello Exception")
}

/**
 * Kotlin does not have checked exceptions
 */

fun main() {

    showName(Person(null))

}