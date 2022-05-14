package demo.singleton

object UtilA {
    fun doObjectAction() {
        println("I'm UtilA.doObjectAction()")
    }
}

class UtilB {
    companion object {
        fun doCompanionAction() {
            println("I'm UtilB.doCompanionAction()")
        }
    }
}

class UtilC {
    companion object {
        @JvmStatic
        fun doJvmStaticAction() {
            println("I'm UtilC.doJvmStaticAction()")
        }
    }
}

fun main() {
    UtilA.doObjectAction()

    UtilB.doCompanionAction()

    UtilC.doJvmStaticAction()
}