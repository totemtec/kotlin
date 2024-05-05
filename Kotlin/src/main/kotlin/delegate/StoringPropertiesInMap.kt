package delegate

class Student(val map: Map<String, Any?>) {
    val name:String by map
    val age:Int by map
}

val student = Student(mapOf(
    "name" to "John",
    "age" to 15
))

class Teacher(val map: MutableMap<String, Any?>) {
    var name:String by map
    var age:Int by map
}

val teacher = Teacher(mutableMapOf(
    "name" to "Ma",
    "age" to 38
))

fun main() {
    println(student.name)
    println(student.age)

    println("==================================================")

    teacher.name = "Jenny"
    teacher.age = 18
    println(teacher.name)
    println(teacher.age)
}