package delegate

interface Printer {
    fun print()
    fun printHello()
}

class CommonPrinter(val x: Int): Printer {
    override fun print() {
        print("print value = $x \n")
    }

    override fun printHello() {
        print("Hello from CommonPrinter")
    }
}

class MyPrinter(p: Printer): Printer by p {
    override fun printHello() {
        print("Hello from MyPrinter")
    }
}

fun main() {
    val p = CommonPrinter(123)
    val myPrinter = MyPrinter(p)
    myPrinter.print()
    myPrinter.printHello()
}